package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class TestProperties {

    @Value("${string.value}")
    private String str;

    @Value("${boolean.value1}")
    private boolean aBoolean;

    @Value("${int.value}")
    private int anInt;

    @Value("${float.value}")
    private float aFloat;




    public void sayHi(){
        System.out.println(str);
        System.out.println(aBoolean);
        System.out.println(anInt);
        System.out.println(aFloat);

    }

}
