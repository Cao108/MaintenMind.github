package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskLog {
    private String username;
    private Date createtime;
    private String description;
    private int quantity;
    private String createtimeString;//处理时间，转换为String方便前端展示

    @Override
    public String toString() {
        return "TaskLog{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", createtimeString='" + createtimeString + '\'' +
                '}';
    }
}
