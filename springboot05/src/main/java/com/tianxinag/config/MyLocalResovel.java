package com.tianxinag.config;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {

    @Override

    public Locale resolveLocale(HttpServletRequest httpServletRequest)  {
        String l = httpServletRequest.getParameter("l");
        System.out.println(l);
        List<String>list=new ArrayList<String>();
        list.add("en_US");
        list.add("zh_CN");
        Locale locale = Locale.getDefault();//链接是否带有区域信息
        if (!StringUtils.isEmpty(l)&&list.contains(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

@Bean
public LocaleResolver localeResolver(){
    return new MyLocalResovel();
}
}
