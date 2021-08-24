package com.abc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/some")
    public String someHandler(){
        return "hello world spring boot";
    }
    @GetMapping("/find/{name}")
    public String findHandler(@PathVariable("name") String name){
        return "查询指定的学生："+name;
    }
}
