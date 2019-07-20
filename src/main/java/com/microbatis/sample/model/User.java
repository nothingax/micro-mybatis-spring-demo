package com.microbatis.sample.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
@Data
public class User {

    private String id;

    private String userName;

    private Integer age;

    private Integer money;

    private Date createtime;

    private List<String> idListQuery;

}
