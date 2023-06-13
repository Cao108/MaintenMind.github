package com.example.maintenmind.controller;


import com.example.maintenmind.pojo.LoginResult;
import com.example.maintenmind.pojo.User;
import com.example.maintenmind.select.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    //登录
    @PostMapping("/login")
    public LoginResult login(@RequestBody User user, HttpSession session){

        LoginResult login = userService.login(user);
        // 将用户信息存储在 Session 中
        session.setAttribute("user",login.getUser());
        return login;
    }
}
