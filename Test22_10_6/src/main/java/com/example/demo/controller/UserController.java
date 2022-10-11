package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/sayhi")
    public String sayHi(){
        System.out.println("sayHi 方法被执行了");
        return "你好！世界";
    }

    @RequestMapping("/sayhello")
    public String sayHello(){
        System.out.println("sayhello 方法被执行了");
        return "世界，你好！";
    }

}
