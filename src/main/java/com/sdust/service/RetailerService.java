package com.sdust.service;

import com.sdust.entity.ResultInfo;
import com.sdust.entity.Retailer;
import com.sdust.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
public interface RetailerService {

    List<Retailer> find(Retailer retailer, Date startTime, Date endTime);

    Integer count(Retailer retailer, Date startTime, Date endTime);

    Retailer get(String id);

    void update(Retailer retailer);

    void deleteById(String retailerId);

    void insert(Retailer retailer);
}
