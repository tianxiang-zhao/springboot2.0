package com.tianxinag.config;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
@Component
public class MyIntercept implements HandlerInterceptor {

    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("这是拦截器");
        String uri=request.getRequestURI();
        System.out.println(uri);
        Object loginUser = request.getSession().getAttribute("loginUserName");
        if (loginUser == null&&uri.startsWith("/admin")) {
            //没有登陆的访问  需要拦截掉  并将其转发到登陆界面
            request.setAttribute("meg", "没有访问权限");
            response.sendRedirect("/toLoginPage");
            return false;
        } else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        int i= Calendar.getInstance().get(Calendar.YEAR);
        request.setAttribute("currentYear",i);
    }

   public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
