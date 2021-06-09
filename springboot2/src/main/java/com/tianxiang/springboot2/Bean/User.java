package com.tianxiang.springboot2.Bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;


/**
 *
 */
@Component //生成当前累的实例对象  存到Ioc容器中。
@ConfigurationProperties(prefix = "user")//将配置文件中前缀为person属性的值映射到当前类的变量上。
@Validated//引入Spring框架支持的数据校验注解
public class User {

    @Email
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
