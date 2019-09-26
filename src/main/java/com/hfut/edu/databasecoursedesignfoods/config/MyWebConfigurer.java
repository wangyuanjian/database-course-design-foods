package com.hfut.edu.databasecoursedesignfoods.config;

import com.hfut.edu.databasecoursedesignfoods.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**").addPathPatterns("/shop/**")
                .addPathPatterns("/food/**").addPathPatterns("/category/**").addPathPatterns("/record/**")
                .excludePathPatterns("/admin/login").excludePathPatterns("/admin/validate").
                excludePathPatterns("/admin/toRegisterPage").excludePathPatterns("/admin/register");
    }
}