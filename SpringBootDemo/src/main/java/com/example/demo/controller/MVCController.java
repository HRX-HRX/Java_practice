package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller //保证Spring初始化此类
@RequestMapping("/mvc")
@Slf4j
public class MVCController {

    @RequestMapping("/index")
    public String getIndex() {
        log.error("我是重定向");
        return "redirect:/index.html";
    }

    @RequestMapping("/index2")
    public String getIndex2() {
        log.error("我是请求转发");
        return "forward:/index.html";
    }

    /*
     * 实现301跳转
     */
    @RequestMapping("/index3")
    public String getIndex3(HttpServletResponse response) {
        response.setStatus(301);
        response.setHeader("Location", "/index.html");
        return null;
    }

    @RequestMapping("/index6")
    @ResponseBody //返回为自定义类型，而非视图
    public String getIndex6() {
        return "/index.html";
    }

}
