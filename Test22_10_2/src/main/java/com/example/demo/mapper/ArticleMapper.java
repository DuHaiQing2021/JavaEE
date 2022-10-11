package com.example.demo.mapper;


import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    public ArticleInfo getArticleById(Integer id);

}
