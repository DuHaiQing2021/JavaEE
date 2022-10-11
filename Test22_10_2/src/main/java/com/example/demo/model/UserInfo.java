package com.example.demo.model;

import lombok.Data;

import java.util.List;

/**
 * 普通实体类
 */
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;
    private List<ArticleInfo> artList;
}
