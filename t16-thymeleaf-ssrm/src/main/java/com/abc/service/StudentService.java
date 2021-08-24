package com.abc.service;

import com.abc.bean.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws Exception;

    List<Student> findStudentsByAge(int age);

    Integer findStudentsCount();
}
