package com.example.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/**","/seckill/**").excludePathPatterns(
                "/",
                "/css/**",
                "/js/**",
                "/img/**",
                "/fonts/**",
                "/user/login",
                "/user/reg",
                "/user/login/execution",
                "/user/reg/execution",
                "/user/codeCheck",
                "/seckill/list",
                "/seckill/*/detail"
        );
    }
}
