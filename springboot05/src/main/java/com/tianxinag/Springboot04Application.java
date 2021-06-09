package com.tianxinag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Springboot04Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04Application.class, args);
    }

}
