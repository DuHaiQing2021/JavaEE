package com.example.demo.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginIntercpet implements HandlerInterceptor {
    /**
     * 返回true表示拦截判断通过，可以访问后面的接口，
     * 如果返回false表示拦截未通过，直接返回结果给前端
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session=request.getSession(false);
        if (session!=null && session.getAttribute("userinfo")!=null){
            return true;
        }
        return false;
    }
}
