package com.microbatis.sample.dao;

import com.microbatis.sample.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Program Name: micro-batis-spring-demo
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/7/29 1:27 AM
 */

@Repository
public interface UserDAO {
    List<User> getUser(Map param);
}
