package com.abc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性封装类
 */
@Data
@ConfigurationProperties(prefix = OperationProperties.CUSTOM_PREFIX)
public class OperationProperties {
    public static final String CUSTOM_PREFIX = "spring.custom";

    private String operator;

}
