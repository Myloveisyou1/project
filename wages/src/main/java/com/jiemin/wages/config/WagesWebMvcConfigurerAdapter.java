package com.jiemin.wages.config;

import com.jiemin.wages.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/26 0026 9:36
 */
//@Configuration
public class WagesWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
