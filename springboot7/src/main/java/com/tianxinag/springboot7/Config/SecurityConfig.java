package com.tianxinag.springboot7.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.spring5.context.webmvc.SpringWebMvcThymeleafRequestContext;

import javax.sql.DataSource;

@EnableWebSecurity  //开启mvc security安全支持 他是个一个组合注解相当于开启 @Configuration  @EnableGlobalAuthentication、
// @Import({WebSecurityConfiguration.class, SpringWebMvcThymeleafRequestContext.class})
//@Configuration
//@Import({WebSecurityConfiguration.class, SpringWebMvcThymeleafRequestContext.class})//作用是根据pom.xml中导入的Web模块和Security模块进项自动化配置
//@EnableGlobalAuthentication //相当于开启自定义的全局认证。
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    //内存身份认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  //重写内存认证方法
        //设置密码编码器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //模拟了测试用户
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authentication= auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder);
//        authentication.withUser("root").password(bCryptPasswordEncoder.encode("root")).roles("common");//设置用户 权限为common。
//        authentication.withUser("lisi").password(bCryptPasswordEncoder.encode("123")).roles("vip");//设置用户 权限为vip。




        //使用jdbc进项身份认证
//        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder);
//        configurer.dataSource(dataSource);
//        configurer.usersByUsernameQuery("select * from ");//查询相应的sql语句
//        configurer.authoritiesByUsernameQuery("select * from ");//查询相应的权限数据表


        //使用UserDetailService进项认证
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);


    }




}
