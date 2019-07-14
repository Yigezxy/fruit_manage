package com.sdust.service.serviceimpl;

import com.sdust.entity.*;
import com.sdust.mapper.ContractMapper;
import com.sdust.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractMapper contractMapper;


    @Override
    public List<ContractVo> findContractList(ContractVo contractVo, Date startTime, Date endTime) {
        return contractMapper.findContractList(contractVo, startTime, endTime);
    }

    @Override
    public int count(ContractVo contractVo, Date startTime, Date endTime) {
        return contractMapper.count(contractVo, startTime, endTime);
    }

    @Override
    public String getMaxBarCode() {
        return contractMapper.getMaxBarCode();
    }

    @Override
    public void insert(Contract contract, String retailerId, String[] commoditiesIdArrays, String[] priceArrays) {
        contractMapper.insert(contract, retailerId);
        //保存中间表信息
        for (int i = 0; i < commoditiesIdArrays.length; i++) {
            MiddleTab middleTab = new MiddleTab();
            middleTab.setMiddleId(UUID.randomUUID().toString());//中间表的ID
            middleTab.setContractId(contract.getContractId());//关联的合同ID
            middleTab.setFruitId(commoditiesIdArrays[i]);//关联的货物ID
            int number = 1;//Integer.parseInt(priceArrays[i].equals("") ? "0" : priceArrays[i]);【原来的没传过来】
            middleTab.setNumber(number);//货物数量
            this.insertMiddleTab(middleTab);
        }
    }

    @Override
    public void insertMiddleTab(MiddleTab middleTab) {
        contractMapper.insertMiddleTab(middleTab);
    }

    @Override
    public Contract get(String contractId) {
        return contractMapper.get(contractId);
    }

    @Override
    public void deleteById(String contractId) {
        contractMapper.deleteById(contractId);
    }
}

