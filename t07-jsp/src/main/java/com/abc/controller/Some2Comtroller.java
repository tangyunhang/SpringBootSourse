package com.abc.controller;

import com.abc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/some2")
public class Some2Comtroller {

    @PostMapping("/register")
    public String someHandler(Student student , Model model){
        model.addAttribute("student",student);
        return "jsp/welcome";
    }
}
