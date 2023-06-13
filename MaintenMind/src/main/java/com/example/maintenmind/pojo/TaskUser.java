package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUser {
    private String content;  //任务内容
    private Date createtime;  //开始时间
    private Date deadline;   //结束时间
    private String username;   //执行任务用户名
    private String productname;   //产品名
    private String warehousename;  //仓库名
    private Integer quantity;    //需要处理货物数量
    private String tasktype;    //目标仓库（当选择转移时才填）
    private int targetWarehouseid;  //任务类型（0-进货，1-卖出，2-转移, 3-新增货物）
}
