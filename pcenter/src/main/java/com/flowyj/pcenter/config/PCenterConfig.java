package com.flowyj.pcenter.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:application.yml")//从该文件中读取属性
public class PCenterConfig{

    /**
     * 配置mysql数据库
     */
    @Value("${mysql.datasource.driverClassName}")
    private String driverClassName;
    /***
     * 地址
     */
    @Value("${mysql.datasource.url}")
    private String url;
    /***
     * 登录名
     */
    @Value("${mysql.datasource.userName}")
    private String userName;
    /***
     * 登陆密码
     */
    @Value("${mysql.datasource.password}")
    private String password;

    /**
     * 初始化数据库配置
     * @return
     */
    @Bean
    public DataSource primaryDataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);//用户名
        dataSource.setPassword(password);//密码

        return dataSource;
    }
}