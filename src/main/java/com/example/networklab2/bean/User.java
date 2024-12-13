package com.example.networklab2.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class User{

    //防止被序列化为json
    @JsonIgnore
    public static List<User> usersList = new ArrayList<User>();

    public User() {}

    public User(String username, String password) {
        this.id = String.valueOf(usersList.size() + 1);
        this.username = username;
        this.password = password;
    }
    String id;
    String username;
    String password;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
