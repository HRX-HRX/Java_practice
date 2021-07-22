package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppCongig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", c -> true);
    }

    //配置拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO:
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //拦截所有的接口
                .excludePathPatterns("/api/user/log")//不拦截登录接口
                .excludePathPatterns("/api/user/reg")//不拦截注册接口
                .excludePathPatterns("/login.html")//不拦截登录页面
                .excludePathPatterns("/reg.html")//不拦截注册页面
                .excludePathPatterns("/reg_err.html")
                .excludePathPatterns("/reg_success.html")
                .excludePathPatterns("/**/**/*.css")
                .excludePathPatterns("/**/**/*.js")
                .excludePathPatterns("/**/**/*.jpg")
                .excludePathPatterns("/**/**/*.png")
        ;
    }
}
