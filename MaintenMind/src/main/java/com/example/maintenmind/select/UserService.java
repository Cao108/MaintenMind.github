package com.example.maintenmind.select;

import com.example.maintenmind.pojo.LoginResult;
import com.example.maintenmind.pojo.User;

    public interface UserService {
        //根据用户输入等账户信息进行查询并返回结果
        LoginResult login(User user);
    }
