package com.example.maintenmind.controller;


import com.example.maintenmind.pojo.TaskLog;
import com.example.maintenmind.select.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasklogs")
@CrossOrigin
public class TaskLogController {
    @Autowired
    private TaskLogService taskLogService;

    @GetMapping
    public List<TaskLog> selectAll(){
        return taskLogService.selectAll();
    }
}
