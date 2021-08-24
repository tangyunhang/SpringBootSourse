package com.abc.service.impl;

import com.abc.bean.Student;
import com.abc.dao.StudentDao;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @CacheEvict(value = "realTimeCache",allEntries = true)
    //采用spring默认事务提交：发生运行时异常回滚，发生受查异常提交
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.insertStudent(student);
    }

    @Cacheable(value = "realTimeCache", key = "'student_'+#age")
    @Override
    public List<Student> findStudentsByAge(int age) {
        return studentDao.selectStudentsByAge(age);
    }

    //Redis在高并发情况下可能会存在哪些问题？
    //1.缓存穿透 ：当从DB中查询结果为null时有可能会出现穿透问题
    // （解决方案：为这些为null的结果赋一个默认值）
    //2.缓存雪崩 ：当缓存中的某些缓存在同一很短的时间段内几乎同时到期，此时就有可能会引发雪崩问题
    // （解决方案：提前规划好系统中所有缓存的到期时间）
    //3.热点缓存 ：当某一个缓存的有效期到达时，其可能会引发热点缓存问题
    //  （解决方案：双重检查锁机制）

    //这里使用双重检查锁，解决其可能出现的热点缓存问题
    @Override
    public Integer findStudentsCount() {
        //获取Redis操作对象
        BoundValueOperations<Object,Object> ops = redisTemplate.boundValueOps("count");
        //从Redis获取Key指定的value
        Object count = ops.get();
        //使用双重检查
        if (count == null){
            //2,3,4
            synchronized (this){
                count = ops.get();
                if (count == null){
                    count = studentDao.selectStudentCount();
                    //将查询结果放入redis，并指定到期时间
                    ops.set(count,10, TimeUnit.SECONDS);
                }
            }
        }
        return (Integer) count;
    }
}
