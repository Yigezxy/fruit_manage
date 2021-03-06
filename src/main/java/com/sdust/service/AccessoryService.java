package com.sdust.service;

import com.sdust.entity.Accessory;
import com.sdust.entity.ResultInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Cierlly on 7/12/2019.
 */
public interface AccessoryService {
    ResultInfo SelectAll();

    List<Accessory> find(Accessory accessory);

    void insert(Accessory accessory);

    void deleteById(String accessoryId);
    void delete(String[] arrays);

    int deleteByFruitId(String fruitId);
}
