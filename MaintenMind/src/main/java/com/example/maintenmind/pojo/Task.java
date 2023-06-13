package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String content;  //任务内容
    private Date createtime;  //开始时间
    private Date deadline;   //结束时间
    private int userid;     //操作人id
    private int adminid;    //管理员id
    private int productid;   //产品id
    private int warehouseid;   //仓库id
    private int quantity;     //需要处理货物数量
    private Integer tasktype;     //目标仓库（当选择转移时才填）
    private int targetWarehouseid;   //任务类型（0-进货，1-卖出，2-转移）

}
