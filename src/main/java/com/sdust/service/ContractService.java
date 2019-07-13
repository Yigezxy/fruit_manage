package com.sdust.service;

import com.sdust.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
public interface ContractService {

    List<ContractVo> findContractList(ContractVo contractVo, Date startTime, Date endTime);

    int count(ContractVo contractVo, Date startTime, Date endTime);

    String getMaxBarCode();

    void insert(Contract contract, String retailerId, String[] commoditiesIdArrays, String[] priceArrays);

    void insertMiddleTab(MiddleTab middleTab);

    Contract get(String contractId);

    void deleteById(String contractId);
}
