package com.tianxiang.springboot2.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value ="test")
public class TestDBconnector implements DBconnector{

    @Override
    public void configure() {
        System.out.println("测试环境数据库连接环境");
    }
}
