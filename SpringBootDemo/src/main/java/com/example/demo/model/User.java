package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private List<ArticleInfo> alist;
}