package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getArticleById() {
        ArticleInfo articleInfo=articleMapper.getArticleById(1);
        log.info(articleInfo.toString());
    }
}