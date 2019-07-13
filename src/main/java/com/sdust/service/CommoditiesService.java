package com.sdust.service;

import com.sdust.entity.Commodities;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/13 0013.
 */
public interface CommoditiesService {

    List<Commodities> find(Commodities commodities, Date startTime, Date endTime, Double startPrice, Double endPrice);

    Integer count(Commodities commodities, Date startTime, Date endTime, Double startPrice, Double endPrice);

    Commodities get(String id);

    void update(Commodities commodities);

    void deleteById(String fruitId);

    void insert(Commodities commodities);
}
