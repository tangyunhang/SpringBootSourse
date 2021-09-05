package com.abc.config;

import com.abc.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 */
@Configuration
@ConditionalOnClass(SomeService.class)//当类路径下必须有指定类
@EnableConfigurationProperties(SomeServiceProperties.class)//开启配置文件中的属性自动转化为封装类
public class SomeServiceAutoConfiguration {
    @Autowired
    private SomeServiceProperties someServiceProperties;

    //当指定属性为true时，才执行
    //若没有没有指定该属性，则其结果和指定该属性值为true相同，即指定该属性的默认值为true
    @Bean
    @ConditionalOnProperty(name="some.service.enable",value = "true",matchIfMissing = true)
    public SomeService someService(){
        return new SomeService(someServiceProperties.getPrefix(),someServiceProperties.getSuffix());
    }
    //当容器中存在Someservice类型的实例时，该方法就不会运行，否则，会运行用于创建someservice实例
    @Bean
    @ConditionalOnMissingBean
    public SomeService someService2(){
        return new SomeService("","");
    }
}
