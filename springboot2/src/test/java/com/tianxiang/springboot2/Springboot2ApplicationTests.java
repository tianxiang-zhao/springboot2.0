package com.tianxiang.springboot2;

import com.tianxiang.springboot2.Bean.*;
import com.tianxiang.springboot2.Controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

//@RunWith(SpringRunner.class)// 加载Springboot 测试注解
@SpringBootTest //加载项目的applicationContext 上下文环境。
class Springboot2ApplicationTests {
    @Autowired
     private HelloController helloController;
    @Autowired
    private Person person;


    @Autowired
    private User user;

    @Autowired
    Myproterties myproterties;

    @Autowired
    private ApplicationContext applicationContext;



    @Value("${person.name}")
    private String name;


    @Value("${app.description}")
    private String secret;


    @Autowired
    private DBconnector dBconnector;
    @Test
    public void dbTest(){
        dBconnector.configure();
    }



    @Test
    void contextLoads() {

        System.out.println("通过@Value实现属性值配置"+name);


        System.out.println("通过数据校验陪配置的邮箱0"+user);

        System.out.println("自己用自己的配置文件配置的class："+myproterties);

       MyService myService = (MyService) applicationContext.getBean("myService");
        MyService myService1 = (MyService) applicationContext.getBean("myService1");
       System.out.println("ImportResource 加载XML文件"+myService);

        System.out.println("@Bean获取该类"+myService1);

        System.out.println("随机数secret:"+secret.toString());

    }

}