package com.sdust.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdust.entity.Commodities;
import com.sdust.entity.ResultInfo;
import com.sdust.entity.User;
import com.sdust.service.CommoditiesService;
import com.sdust.service.UserService;
import com.sdust.service.serviceimpl.AccessoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("commodities")
public class CommoditiesController {
    @Resource
    CommoditiesService commoditiesService;

    @Resource
    AccessoryService accessoryService;

    //跳转至列表页面
    @RequestMapping("/list.action")
    public String list(Model model, Commodities commodities, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date startTime, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endTime, Double startPrice, Double endPrice) {
        commodities.setName(checkStringIsEmpty(commodities.getName()));
        commodities.setLocality(checkStringIsEmpty(commodities.getLocality()));
        List<Commodities> commoditiesList = commoditiesService.find(commodities, startTime, endTime, startPrice, endPrice);
        model.addAttribute("commodities", commodities);//搜索条件回显(货物基本信息)
        model.addAttribute("startPrice", startPrice);//搜索条件回显(价格区间)
        model.addAttribute("endPrice", endPrice);//搜索条件回显(价格区间)
        model.addAttribute("startTime", startTime);//搜索条件回显(时间区间)
        model.addAttribute("endTime", endTime);//搜索条件回显(时间区间)
        model.addAttribute("list", commoditiesList.size() < 1 ? null : commoditiesList);
        model.addAttribute("currentPage", commodities.getCurrentPage());//当前页数==null?1:commodities.getCurrentPage()
        model.addAttribute("startPage", commodities.getStartPage());//当前请求位置，默认为0;==null?0:commodities.getStartPage()
        Integer countNumber = commoditiesService.count(commodities, startTime, endTime, startPrice, endPrice);
        model.addAttribute("countNumber", countNumber);//数据总和
        Integer pageSize = commodities.getPageSize();//==null?10:commodities.getPageSize()
        model.addAttribute("pageSize", pageSize);//每页数据，默认为10
        System.out.print("list的大小呢？？？+" + commoditiesList.size() + "         countNumber " + countNumber + "          pageSize " + pageSize);
        Integer sumPageNumber = countNumber % pageSize == 0 ? (countNumber / pageSize) : ((countNumber / pageSize) + 1);
        model.addAttribute("sumPageNumber", sumPageNumber);//总页数
        return "commodities/commoditiesHome";//转向首页
    }

    @RequestMapping("/editCommodities.action")
    public @ResponseBody//返回json数据
    Commodities editCommodities(@RequestBody String json) {
        String id = JSONObject.parseObject(json).getString("id");
        //@ResponseBody将Commodities转成json格式输出
        return commoditiesService.get(id);
    }

    @RequestMapping("/edit.action")
    public String edit(Model model, Commodities commodities) {
        commoditiesService.update(commodities);
        //构建新的列表查询条件，只需要分页数据即可
        Commodities queryCommodities = new Commodities();
        queryCommodities.setStartPage(commodities.getStartPage());
        queryCommodities.setCurrentPage(commodities.getCurrentPage());
        queryCommodities.setPageSize(commodities.getPageSize());
        return list(model, queryCommodities, null, null, null, null);
    }

    @RequestMapping("/delete.action")
    public String delete(Model model, Commodities commodities) {
        commoditiesService.deleteById(commodities.getFruitId());
        //删除货物下对应的所有附属品
        int result = accessoryService.deleteByFruitId(commodities.getFruitId());
        //log.info("delete fruitId=" + commodities.getFruitId() + "'s accessorys number:" + result);
        //构建新的列表查询条件，只需要分页数据即可
        Commodities queryCommodities = new Commodities();
        queryCommodities.setStartPage(commodities.getStartPage());
        queryCommodities.setCurrentPage(commodities.getCurrentPage());
        queryCommodities.setPageSize(commodities.getPageSize());
        return list(model, queryCommodities, null, null, null, null);
    }

    @RequestMapping("/add.action")
    public String add(Model model, Commodities commodities) {
        commodities.setFruitId(UUID.randomUUID().toString());
        commodities.setCreateTime(new Date());
        commoditiesService.insert(commodities);
        //重新刷新至分页列表页首页
        return list(model, new Commodities(), null, null, null, null);
        //return "redirect:/commodities/list.action?status=-1";
    }

    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : param);
    }//"%"+param+"%"

}
