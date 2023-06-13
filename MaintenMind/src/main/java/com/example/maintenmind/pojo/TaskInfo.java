package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfo {
    private TaskUser taskUser;
    private User user;
}
