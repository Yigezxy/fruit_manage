package com.sdust.service.serviceimpl;

import com.sdust.entity.Commodities;
import com.sdust.entity.ResultInfo;
import com.sdust.entity.User;
import com.sdust.mapper.CommoditiesMapper;
import com.sdust.mapper.UserMapper;
import com.sdust.service.CommoditiesService;
import com.sdust.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class CommoditiesServiceImpl implements CommoditiesService {
    @Resource
    private CommoditiesMapper commoditiesMapper;


    @Override
    public List<Commodities> find(Commodities commodities, Date startTime, Date endTime, Double startPrice, Double endPrice) {
        return commoditiesMapper.find(commodities,startTime,endTime,startPrice,endPrice);
    }

    @Override
    public Integer count(Commodities commodities, Date startTime, Date endTime, Double startPrice, Double endPrice) {
        return commoditiesMapper.count(commodities,startTime,endTime,startPrice,endPrice);
    }

    @Override
    public Commodities get(String id) {
        return commoditiesMapper.get(id);
    }

    @Override
    public void update(Commodities commodities) {
        commoditiesMapper.update(commodities);
    }

    @Override
    public void deleteById(String fruitId) {
        commoditiesMapper.deleteById(fruitId);
    }

    @Override
    public void insert(Commodities commodities) {
        commoditiesMapper.insert(commodities);
    }
}

