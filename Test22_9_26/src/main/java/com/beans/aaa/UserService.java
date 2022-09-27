package com.beans.aaa;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public  void sayHi(){
        System.out.println("你好 Service");
    }
}
