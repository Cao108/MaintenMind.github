package com.example.maintenmind.mapper;

import com.example.maintenmind.pojo.Assets;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AssetsMapper {
    //查询所有数据
    List<Assets> selectAll();
    //查询对应商品在对应仓库的数量
    Integer selectNumber(Assets assets);
}
