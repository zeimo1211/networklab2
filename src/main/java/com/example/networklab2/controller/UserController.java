package com.example.networklab2.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.networklab2.bean.User;
import com.example.networklab2.bean.LoginResponse;

@RestController
@CrossOrigin(origins = "*") // 允许所有来源
public class UserController {

    // 用户列表
    List<User> usersList = User.usersList;


    public  UserController() {
        // 初始化用户列表
        User user1 = new User("zeimo", "123456");
        User user2 = new User("ckj", "123456");
        User user3 = new User("zhangsan","123456");
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

    }


    //登录接口
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public LoginResponse login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        for (User user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // 返回成功的响应
                return new LoginResponse(true, user, null);
            }
        }
        // 返回失败的响应
        return new LoginResponse(false, null, "Invalid username or password");
    }

    //获取用户列表接口
    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return usersList;
    }
}
