package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleInfoMapperTest {

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void getAll() {
        List<ArticleInfo> list = articleInfoMapper.getAll();
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo() {
        List<ArticleInfo> list=articleInfoMapper.getArticleInfo("java",null,0);
        list.forEach(System.out::println);
    }

    @Test
    void addAticle() {
        int result =articleInfoMapper.addAticle("Lucky","今天捡到钱了",1,1,0);
    }

    @Test
    void getArticleInfo2() {
        List<ArticleInfo> list=articleInfoMapper.getArticleInfo2("Lucky",null,0);
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo3() {
        List<ArticleInfo> list=articleInfoMapper.getArticleInfo3("Lucky",null,1);
        list.forEach(System.out::println);
    }

    @Test
    void upArticle() {
        int re=articleInfoMapper.upArticle(3,"Monday",null);
        System.out.println(re);
    }

    @Test
    void delArticleById() {
       int i= articleInfoMapper.delArticleById(
               new int[]{1,2});
        System.out.println(i);
    }
}