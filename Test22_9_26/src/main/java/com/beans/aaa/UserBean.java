package com.beans.aaa;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBean {

    @Bean(name="user1")
    public User setUser(){
        User user=new User();
        user.setId(1);
        user.setName("李四");
        return user;
    }
    @Bean(name = "user2")
    public User setUser2(){
        User user=new User();
        user.setId(2);
        user.setName("张三");
        return user;
    }

}
