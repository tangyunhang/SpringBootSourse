package com.abc.config;

import com.abc.properties.OperationProperties;
import com.abc.service.OperationSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 运算自动配置类
 */
@Configuration
@ConditionalOnClass(OperationSerive.class)
@EnableConfigurationProperties(OperationProperties.class)
public class OperationAutoConfiguration {
    @Autowired
    private OperationProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public OperationSerive operationSerive() {
        return new OperationSerive(properties.getOperator());
    }

}
