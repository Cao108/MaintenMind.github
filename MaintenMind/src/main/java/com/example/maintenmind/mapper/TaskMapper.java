package com.example.maintenmind.mapper;


import com.example.maintenmind.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    //查询产品名是否存在
    Integer selectProductName(String productname);
    //查询仓库名是否存在
    Integer selectWarehouseName(String warehousename);
    //发布任务
    Integer insertTask(Task task);
    //根据用户id查询对应的数据
    List<Task> selectById(int userid);
    //根据产品id查名字
    String selectProductId(int id);
    //根据仓库id查仓库名
    String selectWarehouseId(int id);
}
