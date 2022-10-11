package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据用户Id查询用户
    public UserInfo getUserById(@Param("id") Integer id);

    //修改方法【根据id修改名称】
    public int update(@Param("id") Integer id,
                      @Param("username") String username);

    //删除方法【根据 id 删除用户信息】
    public int del(@Param("id")Integer id);

    //添加用户，返回受影响的行数
    public int add(UserInfo userInfo);

    //添加用户，返回受影响的行数和自增的id
    public int add2(UserInfo userInfo);

    //通过 姓名 查询用户信息
    public List<UserInfo> getUserByName(@Param("username")String username);

    //获取列表根据时间进行倒序或者正序
    public List<UserInfo> getOrderList(@Param("order")String order);

    //登录功能
    public UserInfo login(@Param("username")String username,
                          @Param("password")String password);

    //根据用户id，查询用户信息和用户发表的所有文章
    public UserInfo getUserAndArticleByUid(@Param("uid")Integer uid);


    //使用动态sql添加数据
    public int add3(UserInfo userInfo);



}
