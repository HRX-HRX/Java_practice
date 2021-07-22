package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper

public interface ArticleInfoMapper{
//    @Resource

    public List<ArticleInfo> getAll();

    public List<ArticleInfo> getArticleInfo(String title,String content,int state);

    public List<ArticleInfo> getArticleInfo2(String title,String content,int state);

    public int addAticle(String title,String content,int uid,
                         int state,int rcount);


    public List<ArticleInfo> getArticleInfo3(String title,String content,int state);

    public int upArticle(int id,String title,String content);

    public int delArticleById(int[] ids);

    public int delById(int id);

    public ArticleInfo getdetail(int id);

    //添加文章
    public int add(ArticleInfo articleInfo);
}
