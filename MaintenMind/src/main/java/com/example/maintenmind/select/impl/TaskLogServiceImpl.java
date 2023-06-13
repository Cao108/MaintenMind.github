package com.example.maintenmind.select.impl;

import com.example.maintenmind.mapper.TaskLogMapper;
import com.example.maintenmind.pojo.TaskLog;
import com.example.maintenmind.select.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class TaskLogServiceImpl implements TaskLogService {
    @Autowired
    private TaskLogMapper taskLogMapper;
    @Override
    public List<TaskLog> selectAll() {
        List<TaskLog> taskLogs = taskLogMapper.selectAll();
        //处理数据，把时间变为字符串使前端更好展示
        List<TaskLog> collect = taskLogs.stream().map(taskLog -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createtimeString = sdf.format(taskLog.getCreatetime());
            taskLog.setCreatetimeString(createtimeString);
            return taskLog;
        }).collect(Collectors.toList());
        return collect;
    }
}
