package com.abc.controller;

import com.abc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SomeController {

    @RequestMapping ("/test/index")
    public String indexHandle(Model model){
        model.addAttribute("welcome","thymeleaf");
        model.addAttribute("student",new Student("张三",22));
        //这里的index表示的是thymeleaf试图页面index.html，但不用写扩展名
        return "index";
    }
    @RequestMapping ("/find")
    public String findHandle(HttpServletRequest request,Model model){
        model.addAttribute("welcome","thymeleaf");
        model.addAttribute("student",new Student("张三",22));
        //这里的index表示的是thymeleaf试图页面index.html，但不用写扩展名
        request.getRequestURL();
        return "index";
    }
}
