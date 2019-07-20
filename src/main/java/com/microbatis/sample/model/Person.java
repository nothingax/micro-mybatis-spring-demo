package com.microbatis.sample.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Program Name: micro-mybatis-spring
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/7/19 1:13 AM
 */
@Data
@Accessors(chain = true)
public class Person {
    private String name;
}
