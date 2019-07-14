package com.sdust.service.serviceimpl;

import com.sdust.entity.Accessory;
import com.sdust.entity.ResultInfo;
import com.sdust.mapper.AccessoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Service
public class AccessoryService implements com.sdust.service.AccessoryService {
    @Resource
    private AccessoryMapper accessoryMapper;
    @Override
    public ResultInfo SelectAll() {
        List<Accessory> list = accessoryMapper.selectAll();
        return new ResultInfo(1,list);
    }

    @Override
    public List<Accessory> find(Accessory accessory) {
        return accessoryMapper.selctByFruitId(accessory);
    }

    @Override
    public void insert(Accessory accessory) {
        accessoryMapper.insert(accessory);
    }

    @Override
    public void deleteById(String accessoryId) {
        accessoryMapper.deleteById(accessoryId);
    }

    public void delete(String[] arrays) {
        if(arrays==null||arrays.length==0){
            return;
        }
        StringBuffer ids=new StringBuffer();
        ids.append("'");
        ids.append(arrays[0]);
        ids.append("'");
        for(int i=1;i<arrays.length;i++){
            ids.append(" , '");
            ids.append(arrays[i]);
            ids.append("'");
        }
        accessoryMapper.deleteByIds(ids.toString());

    }

    @Override
    public int deleteByFruitId(String fruitId) {
        return accessoryMapper.deleteByFruitId(fruitId);
    }
}
