package com.abc.controller;

import com.abc.service.OperationSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @Autowired
    private OperationSerive operationSerive;

    @GetMapping("/some/{param1}/{param2}")
    public String someHandler(@PathVariable("param1") String value1 ,@PathVariable("param2") String value2 ){

        return operationSerive.operation(value1,value2).toString();
    }
}
