package com.example.maintenmind.select.impl;


import com.example.maintenmind.mapper.AssetsMapper;
import com.example.maintenmind.mapper.TaskMapper;
import com.example.maintenmind.mapper.UserMapper;
import com.example.maintenmind.pojo.*;
import com.example.maintenmind.select.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private AssetsMapper assetsMapper;

    @Override
    public boolean release(TaskInfo taskInfo) {
        TaskUser taskUser = taskInfo.getTaskUser();
        User user = taskInfo.getUser();
        //查询用户输入执行任务的用户名是否存在
        Integer userid = userMapper.selectUserName(taskUser.getUsername());
        if (userid == null) {
            return false;
        }
        //查询仓库名是否存在
        Integer warehousename = taskMapper.selectWarehouseName(taskUser.getWarehousename());
        if (warehousename == null) {
            return false;
        }
        //查询目的地仓库id
        Integer tasktypeid = taskMapper.selectWarehouseName(taskUser.getTasktype());
        //查询产品id
        Integer productid = taskMapper.selectProductName(taskUser.getProductname());
        if (productid == null) {
            return false;
        }
        //获取任务类型
        int targetWarehouseid = taskUser.getTargetWarehouseid();
        if (targetWarehouseid == 2) {
            //转移
            //转移产品数量要小于现存数量
            Integer selectNumber = assetsMapper.selectNumber(new Assets(taskUser.getProductname(), taskUser.getWarehousename()));
            if (taskUser.getQuantity() >= selectNumber) {
                return false;
            }
        }
        //处理掉所有不合理情况后进行发布任务
        //将前端传过来的数据转换成一个Task对象
        Task task = new Task();
        task.setContent(taskUser.getContent());
        task.setCreatetime(taskUser.getCreatetime());
        task.setDeadline(taskUser.getDeadline());
        task.setUserid(userid);
        task.setAdminid(user.getId());
        task.setProductid(productid);
        task.setWarehouseid(warehousename);
        task.setQuantity(taskUser.getQuantity());
        task.setTasktype(tasktypeid);
        task.setTargetWarehouseid(targetWarehouseid);

        Integer integer = taskMapper.insertTask(task);
        return integer > 0;
    }

    @Override
    public List<TaskUser> selectById(User user) {
        List<Task> tasks = taskMapper.selectById(user.getId());
        //将tasks集合中的task类型变为taskuser类型
        List<TaskUser> taskUsers = tasks.stream().map(task -> {
            TaskUser taskUser = new TaskUser();
            taskUser.setContent(task.getContent());
            taskUser.setCreatetime(task.getCreatetime());
            taskUser.setDeadline(task.getDeadline());
            taskUser.setProductname(taskMapper.selectProductId(task.getProductid()));
            taskUser.setWarehousename(taskMapper.selectWarehouseId(task.getWarehouseid()));
            taskUser.setQuantity(task.getQuantity());
            taskUser.setTargetWarehouseid(task.getTargetWarehouseid());
            if(task.getTargetWarehouseid() == 2){
                taskUser.setTasktype(taskMapper.selectWarehouseId(task.getTasktype()));
            }
            return taskUser;
        }).collect(Collectors.toList());
        return taskUsers;
    }
}
