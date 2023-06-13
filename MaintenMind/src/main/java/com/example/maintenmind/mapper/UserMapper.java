package com.example.maintenmind.mapper;

import com.example.maintenmind.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //查询登录信息
    User selectUser(User user);
    //判断用户名是否存在
    Integer selectUserName(String username);
}
