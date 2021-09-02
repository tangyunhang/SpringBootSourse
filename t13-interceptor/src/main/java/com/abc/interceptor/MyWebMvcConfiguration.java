package com.abc.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SomInterceptor())
                //.addPathPatterns("/first/**");//拦截所有/first/**请求
                .excludePathPatterns("/first/**");//拦截/first/**外的请求
    }
}
