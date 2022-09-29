package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    //1.先得到日志对象
    private final static Logger log=
            LoggerFactory.getLogger(UserController.class);
    

    @RequestMapping("/sayhi")
    public void sayHi(){
        //2.使用日志对象，打印日志
        log.trace("我是trace");
        log.debug("我是 debug");
        log.info("我是 info");
        log.warn("我是 warn");
        log.error("我是 error");
    }

}
