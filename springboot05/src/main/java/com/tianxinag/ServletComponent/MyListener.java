package com.tianxinag.ServletComponent;

import org.springframework.stereotype.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@Component
@WebListener
 public class MyListener implements ServletContextListener{
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed执行了");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized执行了");
    }
}
