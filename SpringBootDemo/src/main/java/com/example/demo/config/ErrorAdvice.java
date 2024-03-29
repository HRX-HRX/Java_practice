package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler
    @ResponseBody
    public Object err(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-1");
        map.put("data", "");
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object err1(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-1");
        map.put("data", "");
        map.put("msg", "空指针异常");
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object err2(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "-1");
        map.put("data", "");
        map.put("msg", "运行时异常");
        return map;
    }
}
