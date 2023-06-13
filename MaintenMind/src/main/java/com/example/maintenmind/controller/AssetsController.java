package com.example.maintenmind.controller;


import com.example.maintenmind.pojo.Assets;
import com.example.maintenmind.select.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin
public class AssetsController {
    @Autowired
    private AssetsService assetsService;
    //查询所有商品信息
    @GetMapping
    public List<Assets> selectAll(){
        List<Assets> assets = assetsService.selectAll();
        return assets;
    }
}
