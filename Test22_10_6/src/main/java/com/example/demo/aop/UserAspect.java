package com.example.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //表明这是一个切面
@Component
public class UserAspect {

    //定义一个切点设置（拦截规则）
    @Pointcut("execution ( * com.example.demo.controller.UserController.*(..))")
    public void pointcut(){

    }

    /**
     * 定义 pointcut 切点的前置通知
     * 在执行目标方法之前执行的方法就叫做前置通知
     */
    @Before("pointcut()")
    public void doBefore(){
        System.out.println("执行前置通知");
    }
}
