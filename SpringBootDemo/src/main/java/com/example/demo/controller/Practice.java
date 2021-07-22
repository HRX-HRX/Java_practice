package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/test")

public class Practice {

    //声明创建一个当前类的日志对象
    private Logger logger = LoggerFactory.getLogger(Practice.class);

    @RequestMapping("/sayhi")
    @ResponseBody
    public String getIndex() {
        logger.error("我的日志信息，等级是 error");
        logger.warn("我的日志信息，等级是 warn");
        logger.info("我的日志信息，等级是 info");
        logger.trace("我的日志信息，等级是 trace");
        logger.debug("我的日志信息，等级是 debug");
        return "hello";
    }

    //文件上传
    @RequestMapping("/reg")
    @ResponseBody
    public Object regin(String username,
                        @RequestPart MultipartFile file) throws IOException {
        //1.动态获取当前项目运行的路径
        String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        path += "/upload/";
        logger.warn("path:" + path);
        //2.文件名（全局唯一id UUID）+ 文件的原始类型
        String fileType = file.getOriginalFilename();//img.png
        //得到文件类型
        fileType = fileType.substring(fileType.lastIndexOf("."));
        //文件名
        String fileName = UUID.randomUUID().toString() + fileType;
        //将文件保存到服务器
        file.transferTo(new File(path + fileName));
        return null;
    }

}
