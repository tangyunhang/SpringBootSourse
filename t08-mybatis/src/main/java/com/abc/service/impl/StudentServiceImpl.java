package com.abc.service.impl;

import com.abc.bean.Student;
import com.abc.dao.StudentDao;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    //采用spring默认事务提交：发生运行时异常回滚，发生受查异常提交
    @Transactional
    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.insertStudent(student);
        if(true){
           throw new Exception("发生受查异常");
        }
        studentDao.insertStudent(student);
    }
}
