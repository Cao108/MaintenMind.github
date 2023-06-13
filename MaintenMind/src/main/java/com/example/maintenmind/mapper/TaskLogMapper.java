package com.example.maintenmind.mapper;


import com.example.maintenmind.pojo.TaskLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskLogMapper {
    //查询所有日志记录
    List<TaskLog> selectAll();
}
