package com.microbatis.sample;

import com.microbatis.sample.dao.PersonDAO;
import com.microbatis.sample.dao.UserDAO;
import com.microbatis.sample.model.User;
import com.xiongyx.session.SqlSession;
import com.xiongyx.session.SqlSessionFactory;
import com.zjw.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program Name: micro-mybatis-spring
 * <p>
 * Description: 测试main
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/7/19 1:06 AM
 */
public class DemoMain {
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.getSession();

        // Object bean = context.getBean("&mapperFactoryBean");
        // PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        Map<String,Object> param = new HashMap<>();
        param.put("id","123");
        param.put("age",12);
        param.put("money",32141);

        // TODO mapper 接口现在必需带map参数，待修改
        List<User> user = userDAO.getUser(param);
        System.out.println(user);

    }
}
