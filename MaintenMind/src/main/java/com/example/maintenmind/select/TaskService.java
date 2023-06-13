package com.example.maintenmind.select;

import com.example.maintenmind.pojo.TaskInfo;
import com.example.maintenmind.pojo.TaskUser;
import com.example.maintenmind.pojo.User;

import java.util.List;

public interface TaskService {
    //发布任务是否成功
    boolean release(TaskInfo taskInfo);
    //查询对应任务
    List<TaskUser> selectById(User user);
}
