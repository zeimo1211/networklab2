package com.example.networklab2.bean;


public class LoginResponse {
    private boolean success;
    private User user; // 可以用自定义的 User 类
    private String message;

    // 构造器
    public LoginResponse(boolean success, User user, String message) {
        this.success = success;
        this.user = user;
        this.message = message;
    }

    // Getter 和 Setter 方法
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
