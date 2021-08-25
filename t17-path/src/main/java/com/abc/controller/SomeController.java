package com.abc.controller;

import com.abc.bean.Student;
import com.abc.bean.StudentFactory;
import com.abc.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SomeController {

    @Autowired(required=true)
    private SomeService someService;

    @GetMapping("/some")
    public String someHandler(){
        return someService.hello();
    }

    @GetMapping("/fore")
    public String foreHandler(){
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("4");
        String dd = "";
        list.forEach(d -> System.out.println(d));
        return dd;
    }
    @GetMapping("/fore1")
    public String foreHandler1(){
        StudentFactory st = new StudentFactory();
        Student s = st.getInstance();
        return "dd";
    }
    @GetMapping("/fore12")
    public String foreHandler12(){
        StudentFactory st = new StudentFactory();
        Student s = st.getInstance();
        return "dd";
    }
}
