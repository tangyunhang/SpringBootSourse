package com.abc.configuration;

import com.abc.servlet.SomeFilter;
import com.abc.servlet.SomeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationContext {
    //注册servlet
    @Bean
    public ServletRegistrationBean<SomeServlet> getServletBean(){

        return new ServletRegistrationBean<>(new SomeServlet(),"/some");
    }

    @Bean
    public FilterRegistrationBean<SomeFilter> getFilterBean(){
        SomeFilter someFilter = new SomeFilter();
        FilterRegistrationBean<SomeFilter> registrationBean = new FilterRegistrationBean<>(someFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
