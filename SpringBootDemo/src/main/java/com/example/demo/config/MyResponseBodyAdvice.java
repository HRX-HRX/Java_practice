package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.xml.ws.Response;
import java.util.HashMap;

@ControllerAdvice

public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    //表示当前的重写是否生效，是否对responsebody增强
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }


    //对返回值的内容统一包装
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("status", 0);
        map.put("data", o);
        map.put("msg", "");
//        if (o instanceof String) {//后端接口
//            //当前方法要给前端返回一个jjson类型的字符串
//            serverHttpResponse.getHeaders().setContentType(mediaType.APPLICATION_JSON);
//            //返回一个json字符串
//            return objectMapper.writeValueAsString(map);
//        }
        return map;
    }
}
