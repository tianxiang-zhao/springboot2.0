package com.tianxiang.springboot2.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "dev")//指定多环境配置类
public class DevDBconnector implements DBconnector{

    @Override
    public void configure() {
        System.out.println("数据库配置环境-dev");
    }
}
