package com.example.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //注意这个注解必须是controller，因为需要与前端交互。所以service不能上传到前端
@ResponseBody
@Slf4j //代替了之前需要通过LoggerFactory.getLogger方法，它自动生成log对象
public class UserService {
//    //得到日志对象
//    private final static Logger log=
//            LoggerFactory.getLogger(UserService.class);


    @RequestMapping("/sayhi2")
    public void sayHi(){
        log.trace("hi trace");
        log.debug("hi debug");
        log.info("hi info");
        log.warn("hi warn");
        log.error("hi error");
    }

}
