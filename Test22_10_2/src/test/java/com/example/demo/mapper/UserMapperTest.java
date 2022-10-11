package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo =userMapper.getUserById(1);
        System.out.println(userInfo);
        Assertions.assertNotNull(userInfo);
    }

    @Test
    @Transactional //在单元测试中添加此注解，表示在方法执行完之后回滚事务
    void update() {
        int result=userMapper.update(2,"张三");
        Assertions.assertEquals(1,result);
    }

    @Test
    @Transactional
    void del() {
        int result=userMapper.del(2);
        System.out.println("受影响的行数："+result);
        Assertions.assertEquals(1,result);

    }

    @Test
    void add() {
        UserInfo userInfo=new UserInfo();
        userInfo.setName("士大夫");
        userInfo.setPassword("123456");
        userInfo.setPhoto("");
        int result=userMapper.add(userInfo);
        System.out.println("添加行数："+result);
        Assertions.assertEquals(1,result);

    }
    @Test
    void add2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setName("ffsdf");
        userInfo.setPassword("123456");
        userInfo.setPhoto("");
        System.out.println("添加之前 id："+userInfo.getId());
        int result=userMapper.add2(userInfo);
        System.out.println("添加行数："+result);
        System.out.println("添加之后 id："+userInfo.getId());
        Assertions.assertEquals(1,result);

    }

    @Test
    void getUserByName() {
        List<UserInfo> userInfoList =userMapper.getUserByName("李四");
        Assertions.assertNotNull(userInfoList);
//        System.out.println(userInfo);
    }

    @Test
    void getOrderList() {
        List<UserInfo> list=userMapper.getOrderList("desc");
        log.info(list.toString());
    }

    @Test
    void login() {
        String username="李四";
        String password="''or 1='1'";
        UserInfo userInfo=userMapper.login(username,password);
        log.info("用户信息："+userInfo);
    }

    @Test
    void getUserAndArticleByUid() {
        UserInfo userInfo=userMapper.getUserAndArticleByUid(2);
        log.info(userInfo.toString());

    }

}