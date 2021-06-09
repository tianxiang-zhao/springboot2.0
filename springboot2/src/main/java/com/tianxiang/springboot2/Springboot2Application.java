package com.tianxiang.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:bean.xml")
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

}
