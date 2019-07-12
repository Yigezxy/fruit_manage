package com.sdust.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdust.entity.Retailer;
import com.sdust.service.RetailerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("retailer")
public class RetailerController {
    @Resource
    private RetailerService retailerService;

    //跳转至列表页面
    @RequestMapping("/list.action")
    public  String list(Model model, Retailer retailer, Date startTime, Date endTime){
        retailer.setName(checkStringIsEmpty(retailer.getName()));
        retailer.setTelphone(checkStringIsEmpty(retailer.getTelphone()));
        retailer.setAddress(checkStringIsEmpty(retailer.getAddress()));
        retailer.setStatus(retailer.getStatus()==-1?null:retailer.getStatus());
        //retailer.setCreateTime(checkStringIsEmpty(retailer.getCreateTime()));【时间改为create】
        //retailer.setStartPage(retailer.getStartPage());
        //retailer.setPageSize(retailer.getPageSize());

        List<Retailer> retailerList = retailerService.find(retailer,startTime,endTime);
        model.addAttribute("list",retailerList.size()<1?null:retailerList);
        model.addAttribute("currentPage",retailer.getCurrentPage()==null?1:retailer.getCurrentPage());//当前页数【默认为1】
        model.addAttribute("startPage",retailer.getStartPage()==null?0:retailer.getStartPage());//当前请求位置，默认为0
        Integer countNumber = retailerService.count(retailer,startTime,endTime);
        model.addAttribute("countNumber",countNumber);//数据总和
        Integer pageSize = retailer.getPageSize()==null?10:retailer.getPageSize();
        model.addAttribute("pageSize",pageSize);//每页数据，默认为10
        Integer sumPageNumber=countNumber%pageSize==0?(countNumber/pageSize):((countNumber/pageSize)+1);
        model.addAttribute("sumPageNumber",sumPageNumber);//总页数
        return "retailer/retailerHome";//转向首页
    }

    @RequestMapping("/editRetailer.action")
    public @ResponseBody Retailer editRetailer(@RequestBody String json){
        String id= JSONObject.parseObject(json).getString("id");
        //@ResponseBody将Retailer转成json格式输出
        return retailerService.get(id);
    }

    @RequestMapping("/edit.action")
    public String edit(Model model,Retailer retailer){
        retailerService.update(retailer);
        //构建新的列表查询条件，只需要分页数据即可
        Retailer queryRetailer = new Retailer();
        queryRetailer.setStartPage(retailer.getStartPage());
        queryRetailer.setCurrentPage(retailer.getCurrentPage());
        queryRetailer.setPageSize(retailer.getPageSize());
        queryRetailer.setStatus(-1);
        return list(model,queryRetailer,null,null);
    }

    @RequestMapping("/delete.action")
    public String delete(Model model,Retailer retailer){
        retailerService.deleteById(retailer.getRetailerId());
        //构建新的列表查询条件，只需要分页数据即可
        Retailer queryRetailer = new Retailer();
        queryRetailer.setStartPage(retailer.getStartPage());
        queryRetailer.setCurrentPage(retailer.getCurrentPage());
        queryRetailer.setPageSize(retailer.getPageSize());
        queryRetailer.setStatus(-1);
        return list(model,queryRetailer,null,null);
    }

    @RequestMapping("/add.action")
    public String add(Model model,Retailer retailer){
        retailer.setRetailerId(UUID.randomUUID().toString());
        retailer.setCreateTime(new Date());

        retailerService.insert(retailer);
        //构建新的列表查询条件，只需要status状态即可
        Retailer queryRetailer = new Retailer();
        queryRetailer.setStatus(-1);
        //return list(model,queryRetailer,null,null);
        return "redirect:/retailer/list.action?status=-1";
    }

    private String checkStringIsEmpty(String param){
        return param==null?null:(param.equals("")?null:"%"+param+"%");
    }
}
