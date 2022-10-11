package com.example.demo.intercept;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice //当前针对controller的通知类（增强类）
public class MyExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public HashMap<String,Object> exceptionAdvice(Exception e){
        HashMap<String,Object> result=new HashMap<>();
        result.put("state",1);
        result.put("data",null);
        result.put("msg","异常"+e.getMessage());
        return result;
    }



}
