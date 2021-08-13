package com.abc.controller;

import com.abc.bean.User;
import com.abc.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference //阿里注解，其相当于<dubbo:reference/>标签
    private UserService userService;

    @PostMapping("/register")
    public String someHandler(User user , Model model) throws Exception{
        userService.addUser(user);
        model.addAttribute("user",user);
        return "/jsp/welcome";
    }
    @PostMapping("/find")
    @ResponseBody
    public List<User> findHandler(int age) {
        return userService.findUserByAge(age);
    }

    @GetMapping("/count")
    @ResponseBody
    public Integer countHandler() {
        return userService.findUserCount();
    }
}
