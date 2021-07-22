package com.example.demo.controller;


import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller //保证Spring初始化此类
@RequestMapping("/met")
@Slf4j
public class MethedController {

    @PostMapping("/param1")
    public Object param1(@RequestParam String username, @RequestParam String
            password) {
        Map<String, String> map = new HashMap<>();
        map.put("用户名", username);
        map.put("密码", password);
        return map;
    }

    @RequestMapping("/reg")
    public String reg(@RequestParam String name,
                      @RequestParam String pass,
                      @RequestParam String img) {
        return "name:" + name + " pass:" + pass + " img:" + img;
    }

    @RequestMapping("/reg3")
    @ResponseBody
    public String reg3(@RequestBody User user) {
        return "username:" + user.getUsername() + "pass:" + user.getPassword();
    }


}
