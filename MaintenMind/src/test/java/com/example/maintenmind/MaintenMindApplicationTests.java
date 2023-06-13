package com.example.maintenmind;

import com.example.maintenmind.mapper.AssetsMapper;

import com.example.maintenmind.mapper.TaskMapper;
import com.example.maintenmind.mapper.UserMapper;
import com.example.maintenmind.pojo.*;
import com.example.maintenmind.select.TaskLogService;
import com.example.maintenmind.select.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MaintenMindApplicationTests {
    @Autowired
    private AssetsMapper assetsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskLogService taskLogService;
    @Autowired
    private TaskMapper taskMapper;

    //测试UserMapper接口
    @Test
    void testUserMapper() {
        Integer admin = userMapper.selectUserName("a");
        System.out.println(admin);
    }

    //测试TaskMapper接口
    @Test
    void testTaskMapper() {
        Task task = new Task("卖出任务2", null, null, 3, 1, 1, 3, 20, null, 1);
        Integer productName = taskMapper.selectProductName("商品1");
        Integer warehouseName = taskMapper.selectWarehouseName("仓库1");
        Integer integer = taskMapper.insertTask(task);
        List<Task> tasks = taskMapper.selectById(2);
        System.out.println(tasks);
    }

    //测试UserService接口
    @Test
    void contextLoads() {
        LoginResult admin = userService.login(new User("admin", "123456"));
        System.out.println(admin);
    }

    //测试AssetsMapper接口
    @Test
    void testAssetsMapper() {
        List<Assets> assets = assetsMapper.selectAll();
        System.out.println(assets);
    }

    //测试TaskLogService接口
    @Test
    void testTaskLogServicer() {
        List<TaskLog> taskLogs = taskLogService.selectAll();
        System.out.println(taskLogs);
    }


}
