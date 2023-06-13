package com.example.maintenmind.select.impl;

import com.example.maintenmind.mapper.AssetsMapper;
import com.example.maintenmind.pojo.Assets;
import com.example.maintenmind.select.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    private AssetsMapper assetsMapper;
    @Override
    public List<Assets> selectAll() {
        return assetsMapper.selectAll();
    }
}
