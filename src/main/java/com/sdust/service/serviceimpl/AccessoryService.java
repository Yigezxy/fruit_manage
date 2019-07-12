package com.sdust.service.serviceimpl;

import com.sdust.entity.Accessory;
import com.sdust.entity.ResultInfo;
import com.sdust.mapper.AccessoryMapper;
import com.sdust.service.IAccessoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Service
public class AccessoryService implements IAccessoryService {
    @Resource
    private AccessoryMapper accessoryMapper;
    @Override
    public ResultInfo SelectAll() {
        List<Accessory> list = accessoryMapper.selectAll();
        return new ResultInfo(1,list);
    }
}
