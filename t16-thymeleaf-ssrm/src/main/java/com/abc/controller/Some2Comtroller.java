package com.abc.controller;

import com.abc.bean.Student;
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
@RequestMapping("/test")
public class Some2Comtroller {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String indexhannle(){
        return "/index";
    }

    @RequestMapping("/register")
    public String someHandler(Student student , Model model){
        studentService.addStudent(student);
        model.addAttribute("student",student);
        return "html/welcome";
    }
    @PostMapping("/find")
    @ResponseBody
    public List<Student> findHandler(int age) {
        return studentService.findStudentsByAge(age);
    }
    @RequestMapping("/findId")
    public String findIdHandle(int id,Model model) {
        Student student = studentService.findStudentsById(id);
        model.addAttribute("student",student);
        return "html/welcome";
    }
    @GetMapping("/count")
    @ResponseBody
    public Integer countHandler() {
        return studentService.findStudentsCount();
    }
}
