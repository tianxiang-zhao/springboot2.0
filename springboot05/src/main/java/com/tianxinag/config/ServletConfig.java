package com.tianxinag.config;

import com.tianxinag.ServletComponent.MyFilter;
import com.tianxinag.ServletComponent.MyListener;
import com.tianxinag.ServletComponent.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

//@Configuration  //使用了自动组件扫描 就不用该配置文件了
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
    ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>(myServlet, "/myServlet");
    return myServletServletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter){
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/toLoginPage","/admin"));//需要拦截的路径
        return myFilterFilterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean getListener(MyListener listener){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(listener);
        return servletListenerRegistrationBean;
    }

}
