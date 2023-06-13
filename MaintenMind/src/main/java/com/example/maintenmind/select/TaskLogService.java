package com.example.maintenmind.select;

import com.example.maintenmind.pojo.TaskLog;

import java.util.List;

public interface TaskLogService {
    //查询所有订单信息
    List<TaskLog> selectAll();
}
