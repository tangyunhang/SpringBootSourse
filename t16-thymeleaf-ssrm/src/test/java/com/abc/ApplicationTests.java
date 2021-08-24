package com.abc;

import com.abc.service.SomeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {
    @Autowired
    private SomeService someService;
    @Test
    void contextLoads() {
        System.out.println(someService.hello());
    }

}
