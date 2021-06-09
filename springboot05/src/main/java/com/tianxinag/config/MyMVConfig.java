package com.tianxinag.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVConfig implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        //请求toLoginPage 和login.html 都会自动映射到login.html页面
        registry.addViewController("/toLoginPage").setViewName("login");//自动跳转到login页面
        registry.addViewController("/login.html").setViewName("login");
    }


    @Autowired
    MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**") 拦截的请求 /**表示拦截所有请求
        //excludePathPatterns()  排除一些 不用验证的请求
        //静态资源  css js springboot已经做好了静态资源映射
        registry.addInterceptor(myIntercept).addPathPatterns("/**").excludePathPatterns("/login.html");
    }

}
