package com.tianxiang.springboot2.Bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

   @Bean(name = "myService1")//将标志方法的返回值 存到spring容器中   name 就是它的标识 applicationContext.getBean("myService1");。
    public  MyService myService(){
        return new MyService();
    }
}
