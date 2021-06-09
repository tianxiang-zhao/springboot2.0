package com.tianxiang.springboot6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//开启基于注解的缓存支持
public class Springboot6Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot6Application.class, args);
    }

}
