package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
