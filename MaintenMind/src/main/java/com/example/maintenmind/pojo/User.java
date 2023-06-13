package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    //1为维护经理   0为责任方
    private int isAdmin;


    //登录时封装数据
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
