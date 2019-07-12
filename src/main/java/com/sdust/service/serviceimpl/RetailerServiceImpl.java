package com.sdust.service.serviceimpl;

import com.sdust.entity.ResultInfo;
import com.sdust.entity.Retailer;
import com.sdust.entity.User;
import com.sdust.mapper.RetailerMapper;
import com.sdust.mapper.UserMapper;
import com.sdust.service.RetailerService;
import com.sdust.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class RetailerServiceImpl implements RetailerService {
    @Resource
    private RetailerMapper retailerMapper;


    @Override
    public List<Retailer> find(Retailer retailer, Date startTime, Date endTime) {
        return retailerMapper.find(retailer, startTime, endTime);
    }

    @Override
    public Integer count(Retailer retailer, Date startTime, Date endTime) {
        return retailerMapper.count(retailer, startTime, endTime);
    }

    @Override
    public Retailer get(String id) {
        return retailerMapper.get(id);
    }

    @Override
    public void update(Retailer retailer) {
        retailerMapper.update(retailer);
    }

    @Override
    public void deleteById(String retailerId) {
        retailerMapper.deleteById(retailerId);
    }

    @Override
    public void insert(Retailer retailer) {
        retailerMapper.insert(retailer);
    }
}

