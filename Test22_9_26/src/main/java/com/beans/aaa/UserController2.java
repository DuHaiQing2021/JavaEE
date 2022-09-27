package com.beans.aaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController2 {

    @Autowired
    private UserService userService;

    public void sayHi(){
        this.userService.sayHi();
    }

}
