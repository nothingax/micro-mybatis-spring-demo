package com.microbatis.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Program Name: micro-mybatis-spring
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/7/19 1:07 AM
 */
@Configuration
@ComponentScan(basePackages = {"com.microbatis","com.zjw"})
public class Config {
    private String name;
}
