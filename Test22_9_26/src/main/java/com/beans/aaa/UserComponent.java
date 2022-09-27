package com.beans.aaa;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("你好 component");
    }
}
