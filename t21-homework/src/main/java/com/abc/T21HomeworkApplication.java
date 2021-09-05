package com.abc;

import com.abc.annotaion.EnableOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOperation
public class T21HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
