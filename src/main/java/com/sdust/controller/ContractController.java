package com.sdust.controller;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.sdust.entity.*;
import com.sdust.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("contract")
public class ContractController {
    @Resource
    ContractService contractService;
    @Resource
    RetailerService retailerService;
    @Resource
    CommoditiesService commoditiesService;
    @Resource
    AccessoryService accessoryService;

    //跳转至列表页面
    @RequestMapping("/list.action")
    public String list(Model model, ContractVo contractVo, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date startTime, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endTime) {
        contractVo.setBarCode(checkStringIsEmpty(contractVo.getBarCode()));
        contractVo.setRetailerName(checkStringIsEmpty(contractVo.getRetailerName()));
        contractVo.setType(contractVo.getType() == -1 ? null : contractVo.getType());
        contractVo.setStartPage(contractVo.getStartPage());
        List<ContractVo> contractList = contractService.findContractList(contractVo, startTime, endTime);
        model.addAttribute("list", contractList.size() < 1 ? null : contractList);
        model.addAttribute("currentPage", contractVo.getCurrentPage());//当前页数
        model.addAttribute("startPage", contractVo.getStartPage());//当前请求位置，默认为0
        int countNumber = contractService.count(contractVo, startTime, endTime);
        model.addAttribute("countNumber", countNumber);//数据总和
        int pageSize = contractVo.getPageSize();
        model.addAttribute("pageSize", pageSize);//每页数据，默认为10
        int sumPageNumber = countNumber % pageSize == 0 ? (countNumber / pageSize) : ((countNumber / pageSize) + 1);
        model.addAttribute("sumPageNumber", sumPageNumber);//总页数
        return "contract/contractHome";//转向首页
    }

    @RequestMapping("/toAddPage.action")
    public String toAddPage(Model model) {
        return "contract/addContract";//转向添加页面
    }

    @RequestMapping("/getAllRetailer.action")
    public @ResponseBody
    List<Retailer> getAllRetailer(@RequestBody String json) {
        Retailer retailer = new Retailer();
        retailer.setStatus(1);//选择启用的零售商
        if (!StringUtils.isNullOrEmpty(json)) {
            String name = JSONObject.parseObject(json).getString("name");
            if (!StringUtils.isNullOrEmpty(name)) {
                //param.put("name", "%"+name+"%");//零售商姓名
                retailer.setName(name);
            }
        }
        List<Retailer> retailerList = retailerService.find(retailer, null, null);
        return retailerList;
    }

    @RequestMapping("/getAllCommodities.action")
    public @ResponseBody
    List<Commodities> getAllCommodities(@RequestBody String json) {
        Commodities commodities = new Commodities();
        if (!StringUtils.isNullOrEmpty(json)) {
            String name = JSONObject.parseObject(json).getString("name");
            if (!StringUtils.isNullOrEmpty(name)) {
                commodities.setName(name);
            }
        }
        List<Commodities> commoditiesList = commoditiesService.find(commodities, null, null, null, null);
        return commoditiesList;
    }

    @RequestMapping("/getCommoditiesAndAccessory.action")
    public @ResponseBody
    List<Map<String, Object>> getCommoditiesAndAccessory(String[] arrays) {
        List<Map<String, Object>> cList = new ArrayList<Map<String, Object>>();
        Map<String, Object> cMap = null;
        for (int i = 0; i < arrays.length; i++) {
            cMap = new HashMap<String, Object>();
            String fruitId = arrays[i];
            cMap.put("commodities", commoditiesService.get(fruitId));//获取货物信息
            Accessory accessory = new Accessory();
            accessory.setFruitId(fruitId);
            cMap.put("accessory", accessoryService.find(accessory));//获取货物下的附属品信息
            cList.add(cMap);//添加至List
        }
        return cList;
    }

    @RequestMapping("/add.action")
    public String add(Model model, Contract contract, String retailerId, String[] commoditiesIdArrays, String[] priceArrays) {
        contract.setRetailer(retailerService.get(retailerId));
        //生成合同编号
        String barCode = getCode();
        contract.setBarCode(barCode);
        //设置ID以及创建日期
        contract.setContractId(UUID.randomUUID().toString());
        contract.setCreateTime(new Date());
        //保存合同基础信息
        contractService.insert(contract, retailerId, commoditiesIdArrays, priceArrays);
        //初始化页面搜索信息封装对象
        model.addAttribute("reaultMessage", "添加成功！合同编号为" + barCode);
        return "contract/addContract";//返回添加页面
    }

    private String getCode() {
        //取当日年月日信息做编号头
        String codeHead = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String barCode = "";
        //从数据库中取出最大的编号信息，在其基础上加1
        String MaxBarcode = contractService.getMaxBarCode();
        if (!StringUtils.isNullOrEmpty(MaxBarcode)) {
            //如果最大编号日期是今天，则取其自增数字部分
            if (MaxBarcode.substring(0, 8).equals(codeHead)) {
                MaxBarcode = MaxBarcode.substring(8);//拿到除了年月日之外的数字
            } else {
                MaxBarcode = "0";//如果最大编号不是今日，那么该单是今日第一单
            }
        } else {
            MaxBarcode = "0";//如果没有最大编号，那么该单是系统第一单
        }
        int MaxNumber = Integer.parseInt(MaxBarcode);
        //在今日最大编号基础上加1
        int newNumber = MaxNumber + 1;
        if (newNumber <= 9) {//日期与自增数字拼接为编号
            barCode = codeHead + "000" + newNumber;//一位数
        } else if (newNumber >= 10 && newNumber <= 99) {
            barCode = codeHead + "00" + newNumber;//两位数
        } else if (newNumber >= 100 && newNumber <= 999) {
            barCode = codeHead + "0" + newNumber;//三位数
        } else {
            barCode = codeHead + newNumber;//三位以上的数
        }
        return barCode;
    }

    @RequestMapping("/getContractDetail.action")
    public String getContractDetail(Model model, String contractId) {
        Contract contract = contractService.get(contractId);
        model.addAttribute("contract", contract);
        return "contract/contractDetail";//跳转至详情页
    }

    @RequestMapping("/delete.action")
    public String delete(Model model, ContractVo contractVo) {
        contractService.deleteById(contractVo.getContractId());
        //构建新的列表查询条件，只需要分页数据即可
        ContractVo queryContract = new ContractVo();
        queryContract.setType(-1);
        queryContract.setStartPage(contractVo.getStartPage());
        queryContract.setCurrentPage(contractVo.getCurrentPage());
        queryContract.setPageSize(contractVo.getPageSize());
        return list(model, queryContract, null, null);
    }

    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : param);//"%"+param+"%"
    }

}
