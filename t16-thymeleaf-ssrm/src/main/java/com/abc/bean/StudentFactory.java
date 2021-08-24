package com.abc.bean;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

/**
 * 通过当前类的getInstance()方法获取一个单例的Student对象
 * 当前代码存在线程安全问题
 * （第一个请求执行1。3两步，第二个请求过来，由于student对象已经生成，但还没初始化，会导致返回的对象中不存在值）
 * 解决方案：
 * 1、方法上加同步锁，使方法变为同步方法
 * 2、在存在线程安全问题的成员变量声明前添加volatile
 * 3、若存在线程安全问题的成员变量为integer，long，boolean等，可以将他们定义为atomicxxx类型
 */
@Component //当前类是单例
public class StudentFactory {
    private Student student;

    public Student getInstance(){
        if (student == null){
             synchronized (this) {
                 if (student == null) {
                     //底层三部分组成
                     //1。申请堆空间
                     //2。使用对象初始化数据数据初始化堆空间
                     //3。将student引用指向堆空间
                     student = new Student("张三",13);
                 }
             }
        }
        return student;
    }
}
