package com.abc.controller;

import com.abc.bean.Student;
import com.abc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
