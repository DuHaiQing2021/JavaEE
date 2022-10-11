package com.example.demo.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //一定要注意不要写错
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private LoginIntercpet loginIntercpet;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercpet).
                addPathPatterns("/**").  //拦截所有的url
                excludePathPatterns("/user/login"). //除了这几个url不拦截
                excludePathPatterns("/user/reg").
                excludePathPatterns("/login.html");
    }
}
