package com.sdust.entity;

import lombok.Data;

import java.util.List;
@Data
public class CommoditiesVo {
	private String fruitId;
    private String name;
    private Double price;
    private String locality;
    private String number;//该货物数量
    private List<Accessory> accessoryList;

}
