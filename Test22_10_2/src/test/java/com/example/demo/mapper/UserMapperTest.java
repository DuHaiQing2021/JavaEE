package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo =userMapper.getUserById(1);
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
        userInfo.setUsername("王五");
        userInfo.setPassword("123456");
        userInfo.setPhoto("");
        int result=userMapper.add(userInfo);
        System.out.println("添加行数："+result);
        Assertions.assertEquals(1,result);

    }
    @Test
    void add2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("老六");
        userInfo.setPassword("123456");
        userInfo.setPhoto("");
        System.out.println("添加之前 id："+userInfo.getId());
        int result=userMapper.add2(userInfo);
        System.out.println("添加行数："+result);
        System.out.println("添加之后 id："+userInfo.getId());
        Assertions.assertEquals(1,result);

    }
}