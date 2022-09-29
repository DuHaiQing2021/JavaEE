package com.example.demo.controller;


import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@ResponseBody //表示：返回一个非静态页面的数据
@RequestMapping("/user")  //类上面的RequestMapping可以省略
@Slf4j
public class UserController {


    @RequestMapping("/sayhi") //必须加上RequestMapping的，否则这个方法不能在页面上实现
    public String sayHi(){
        return "你好，世界";//此处默认返回静态页面，但这是一个非静态页面的数据所以如果没有
        // Responsebody返回一个404，客户端页面找不到
    }

    @RequestMapping(method = RequestMethod.POST,value = "/sayhi2")
    public String sayhi2(){
        return "你好，世界2";
    }

    /**
     * 只支持post请求类型的访问方式
     * @return
     */
    @PostMapping("/sayhi3")
    public String sayHi3(){
        return "你好，世界3";
    }

    /**
     * 只支持get请求类型的访问方式
     */
    @GetMapping("/sayhi4")
    public String sayHi4(){
        return "你好，世界4";
    }

    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id){
        //不查数据库返回用户对象
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setUsername("张三");
        userInfo.setAge(18);
        return userInfo;
    }


    @RequestMapping("/login")
    public String login(@RequestParam(value = "name",required = false)
                                    String username,String password){
        return "用户名："+username+"<br>密码："+password;
    }

    @RequestMapping("/reg")
    public String reg(@RequestBody UserInfo userInfo){
        return "用户信息"+userInfo;
    }

    @RequestMapping("/hero/{id}/{name}")
    public String getHeroInfo(@PathVariable Integer id,@PathVariable String name){
        return "ID:"+id+"| name:"+name;
    }

    @Value("${img.path}") //图片目录
    private String imgPath;

    @RequestMapping("/upimg")
    public boolean upImg(Integer uid, @RequestPart("img")MultipartFile file){
        boolean result=false;
        //1.目录
        //2.图片名称（图片名称不能重复）【UUID】
        //3.获取原上传图片的格式
        String fileName =file.getOriginalFilename();
        fileName=fileName.substring(fileName.lastIndexOf("."));//得到后缀
        fileName= UUID.randomUUID().toString()+fileName;
        //保存图片到本地目录
        try {
            file.transferTo(new File(imgPath+fileName));
            result=true;
        } catch (IOException e) {
            log.error("上传图片失败："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/cookie")
    public void getCookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for (Cookie item:cookies){
            log.info("Cookie Name: "+item.getName());
        }

    }

}
