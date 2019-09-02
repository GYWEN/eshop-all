package com.eshop.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * 主要可以将mapper。xml文件和接口分离开来
 */
@Controller
@MapperScan("com.eshop.mapper")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.eshop.model");

        PathMatchingResourcePatternResolver matchingResourcePatternResolver =
                new PathMatchingResourcePatternResolver();
        Resource[] resource = matchingResourcePatternResolver.getResources("classpath:mapper/*.xml");
        factoryBean.setMapperLocations(resource);

        return factoryBean.getObject();
    }
}
