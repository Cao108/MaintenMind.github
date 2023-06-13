package com.example.maintenmind.select.impl;

import com.example.maintenmind.mapper.UserMapper;
import com.example.maintenmind.pojo.LoginResult;
import com.example.maintenmind.pojo.User;
import com.example.maintenmind.select.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginResult login(User user) {
        User selectUser = userMapper.selectUser(user);
        LoginResult loginResult = new LoginResult();
        loginResult.setSuccess(selectUser != null);
        loginResult.setUser(selectUser);
        if(selectUser != null){
            //登录成功
            if(selectUser.getIsAdmin() == 1){
                //管理员
                loginResult.setRedirectUrl("http://localhost:8080/admin.html");
            }else {
                //普通用户
                loginResult.setRedirectUrl("http://localhost:8080/user.html");
            }
        }
        return loginResult;
    }
}
