package com.microbatis.sample;

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
 * Description:
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

        Map<String,Object> param = new HashMap<>();
        param.put("id","123");
        param.put("age",12);
        param.put("money",32141);

        // todo 动态sql
        List<Object> list = sqlSession.selectList("test.dao.UserMapper.getUserByParam",param);
        System.out.println(list);
    }
}
