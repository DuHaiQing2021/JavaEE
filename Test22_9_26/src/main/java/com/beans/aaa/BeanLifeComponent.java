package com.beans.aaa;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class BeanLifeComponent implements BeanNameAware {
    //初始化
    @PostConstruct
    public void postConstruct() {
        System.out.println("执⾏ PostConstruct()");
    }

    //指定方法
    public void init() {
        System.out.println("执⾏ BeanLifeComponent init-method");
    }



    //销毁
    @PreDestroy
    public void preDestroy() {
        System.out.println("执⾏：preDestroy()");
    }

    public void setBeanName(String s) {
        System.out.println("执⾏了 setBeanName ⽅法：" + s);
    }
}
