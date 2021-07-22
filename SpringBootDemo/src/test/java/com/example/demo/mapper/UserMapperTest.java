package com.example.demo.mapper;

import com.example.demo.model.User;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //表示执行完业务之后回滚,不会将信息存储到数据库中
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("白骨精");
        user.setPassword("长生不老");

        int result = userMapper.addUser(user); //返回的永远是修改的行数
        System.out.println(result);

        System.out.println(user.getId());
    }

    @Test
    void getUserById() {
        User user=userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    void getUserByNameAndPassword() {
        User user=userMapper.getUserByNameAndPassword("唐僧","去取经");
        System.out.println(user);
    }

    @Test
    void getAll() {
        List<User> list=userMapper.getAll();
        System.out.println(list);
    }

    @Test
    void delById() {
        int result = userMapper.delById(0);
        System.out.println(result);

    }

    @Test
    void upUser() {
        int result = userMapper.upUser(6,"猪八戒");
        System.out.println(result);
    }

    @Test
    void getList() {
        List<User> list = userMapper.getList("desc");
        list.forEach(System.out::println);
    }

    @Test
    void getListByName() {
        String username = "%' or username='%";

        //TODO:手动过滤SQL注入
        username = username.replace("'","").replace("or","");


        List<User> list = userMapper.getListByName(username);
        list.forEach(System.out::println);
    }

    @Test
    void getListByName2() {
        String username = " %' or username='%";
        List<User> list = userMapper.getListByName2(username);
        list.forEach(System.out::println);
    }

    @Test
    void getFullUser() {
        User user = userMapper.getFullUser(7);
        System.out.println(user);
    }


}