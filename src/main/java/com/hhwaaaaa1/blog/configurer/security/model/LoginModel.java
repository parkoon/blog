package com.hhwaaaaa1.blog.configurer.security.model;

public class LoginModel {
    private String userId;
    private String userPassword;


    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserPassword(){
        return this.userPassword;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}
