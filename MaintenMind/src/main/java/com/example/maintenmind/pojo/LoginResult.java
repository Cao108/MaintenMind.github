package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    private boolean success;      // 标识登录成功与否
    private String redirectUrl;     // 登录成功后应该跳转的页面
    private User user;   //用户登录信息
}
