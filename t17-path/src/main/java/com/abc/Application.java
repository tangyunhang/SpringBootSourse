package com.abc;

import com.abc.contextInitializer.TestApplicationContextInitializer;
import com.abc.contextInitializer.TestApplicationContextInitializer2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationListener;

//启动类
@EnableCaching //开启缓存
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        SpringApplication springApplication=new SpringApplication(Application.class);
        springApplication.addListeners((ApplicationListener<ApplicationStartingEvent>) event->{
            System.out.println("Starting");
        });
        springApplication.addListeners((ApplicationListener<ApplicationStartedEvent>) event->{
            System.out.println("Started");
        });
        springApplication.addListeners((ApplicationListener<ApplicationFailedEvent>) event->{
            System.out.println("Failed");
        });
        springApplication.addListeners((ApplicationListener<ApplicationPreparedEvent>) event->{
            System.out.println("Prepared");
        });

        springApplication.addListeners((ApplicationListener<SpringApplicationEvent>) event->{
            System.out.println("SpringApplication");
        });

        springApplication.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event->{
            System.out.println("EnvironmentPrepare");
        });

        springApplication.addListeners((ApplicationListener<ApplicationReadyEvent>) event->{
            System.out.println("Ready");
        });
        springApplication.addInitializers(new TestApplicationContextInitializer());
        springApplication.addInitializers(new TestApplicationContextInitializer2());



        springApplication.run(args);
    }

}
