package com.sdust.service;

import com.sdust.entity.Accessory;
import com.sdust.entity.ResultInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Cierlly on 7/12/2019.
 */
public interface IAccessoryService {
    ResultInfo SelectAll();

    List<Accessory> find(Map<String, Object> map);

    void insert(Accessory accessory);

    void deleteById(String accessoryId);
    void delete(String[] arrays);
}
