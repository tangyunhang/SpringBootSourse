package com.abc.service;

import com.abc.bean.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> findStudentsByAge(int age);

    Integer findStudentsCount();

    Student findStudentsById(int id);
}
