package com.example.maintenmind.controller;


import com.example.maintenmind.pojo.TaskInfo;
import com.example.maintenmind.pojo.TaskUser;
import com.example.maintenmind.pojo.User;
import com.example.maintenmind.select.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    //发布任务
    @PostMapping
    public boolean release(@RequestBody TaskUser taskUser, HttpSession session){
        //从session中获取user数据
        User user = (User) session.getAttribute("user");
        //封装获取到的数据
        TaskInfo taskInfo = new TaskInfo(taskUser,user);
        //进行发布任务
        boolean release = taskService.release(taskInfo);
        return release;
    }

    //查询对应任务
    @GetMapping
    public List<TaskUser> selectById(HttpSession session){
        //从session中获取user数据
        User user = (User) session.getAttribute("user");
        List<TaskUser> taskUsers = taskService.selectById(user);
        return taskUsers;
    }
}
