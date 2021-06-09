package com.tianxiang.springboot2.Bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component //指定当前类为配置  也可以使用@component代替 并将其放入ioc容器中
@PropertySource("classpath:myapplication.properties")//指定自定义配置文件的名称和位置。
//@EnableConfigurationProperties(Myproterties.class)//开启配置类属性的注入功能。
@ConfigurationProperties(prefix = "test")
public class Myproterties {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Myproterties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
