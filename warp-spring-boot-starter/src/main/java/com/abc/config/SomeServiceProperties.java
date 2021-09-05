package com.abc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性封装类，将配置文件中的相关属性值封装到当前实例中
 * some.service.prefix 指定前缀
 * ome.service.suffix 指定后缀
 */
@Data
@ConfigurationProperties("some.service")
public class SomeServiceProperties {
    private String prefix;
    private String suffix;
}
