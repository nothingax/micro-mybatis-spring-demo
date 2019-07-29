package com.microbatis.sample.config;

import com.microbatis.sample.dao.UserDAO;
import com.xiongyx.datasource.DataSource;
import com.xiongyx.datasource.DruidDataSourceManager;
import com.xiongyx.session.SqlSessionFactory;
import com.zjw.spring.MapperFactoryBean;
import com.zjw.spring.MapperScannerConfigurer;
import com.zjw.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Program Name: microbatisspringdemo
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/7/20 6:01 PM
 */
@Configuration
public class BatisConfig {

    @Bean("dataSource")
    DataSource dataSource() {
        // TODO 从配置文件获取数据
        // TODO  toy的数据源设计比较奇怪，没有使用数据源api，而是自己定义了connection接口
        // 内部强制转为使用druid数据源，抹杀了接入其他数据的可能性。
        Map<String, String> properties = new HashMap<String, String>(4);
        properties.put("driver", "com.mysql.jdbc.Driver");
        properties.put("url", "jdbc:mysql://localhost:3306/toy_framework?useUnicode=true&amp;characterEncoding=utf-8");
        properties.put("username", "root");
        properties.put("password", "123456");
        DataSource dataSource = new DruidDataSourceManager(properties);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.dataSource());

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));


        SqlSessionFactory sqlSessionFactoryBeanObject = null;
        try {
            sqlSessionFactoryBeanObject = (SqlSessionFactory) sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBeanObject;
    }

    @Bean
    public UserDAO userDAO() {
        MapperFactoryBean<UserDAO> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(UserDAO.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean());
        return factoryBean.getObject();
    }
}
