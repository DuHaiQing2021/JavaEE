package com.example.demo.controller;

import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(HttpServletRequest req, HttpServletResponse resp, String username, String password) throws IOException {
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if (username.equals("zhangsan") && password.equals("123456")) {
                HttpSession session = req.getSession(true);
                session.setAttribute("userinfo","userinfo");
                return true;
            } else {
                return false;
            }
        }
        //执行到此行代码表示未登录，未登录就跳转到登录页面
        resp.sendRedirect("/login.html");
        return false;
    }
    @RequestMapping("/index")
    public int index(HttpServletRequest req, String username, String password) {

        return 10/0;
    }

}
