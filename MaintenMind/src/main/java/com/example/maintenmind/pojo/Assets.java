package com.example.maintenmind.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assets {
    private String productName;
    private String warehouseName;
    private int quantity;

    public Assets(String productName, String warehouseName) {
        this.productName = productName;
        this.warehouseName = warehouseName;
    }
}
