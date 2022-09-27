package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Value("${server.port}") //读取配置
    private  Integer port;

    @ResponseBody  //返回一个非静态页面得数据
    @RequestMapping("/sayhi") //设置路由地址（不要出现大写），Linux中不支持大写
    public String sayHi(){
        return  "hello world. |"+port;
    }


}
