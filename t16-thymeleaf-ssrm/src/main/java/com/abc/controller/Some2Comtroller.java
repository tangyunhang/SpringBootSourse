package com.abc.controller;

import com.abc.bean.Student;
import com.abc.bean.User;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/some2")
public class Some2Comtroller {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String someHandler(Student student , Model model) throws Exception{
        studentService.addStudent(student);
        model.addAttribute("student",student);
        return "jsp/welcome";
    }
    @PostMapping("/find")
    @ResponseBody
    public List<Student> findHandler(int age) {
        return studentService.findStudentsByAge(age);
    }

    @GetMapping("/count")
    @ResponseBody
    public Integer countHandler() {
        return studentService.findStudentsCount();
    }
}
