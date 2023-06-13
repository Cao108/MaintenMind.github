package com.example.maintenmind.select;

import com.example.maintenmind.pojo.Assets;

import java.util.List;

public interface AssetsService {
    //查询所有商品信息
    List<Assets> selectAll();
}
