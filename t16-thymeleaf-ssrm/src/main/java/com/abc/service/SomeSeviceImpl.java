package com.abc.service;

import org.springframework.stereotype.Service;

@Service
public class SomeSeviceImpl implements SomeService{
    @Override
    public String hello() {
        return "hello hello";
    }
}
