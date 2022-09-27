package com.beans.aaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Autowired
    @Qualifier(value = "user1")
    public User user;

    public void sayHi(){
        System.out.println("你好 Cotroller   "+user);
    }

}
