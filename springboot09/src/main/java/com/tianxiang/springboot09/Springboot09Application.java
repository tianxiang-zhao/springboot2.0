package com.tianxiang.springboot09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Springboot09Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09Application.class, args);
    }

}
