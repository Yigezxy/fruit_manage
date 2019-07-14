package com.sdust.controller;

import com.sdust.entity.Accessory;
import com.sdust.service.serviceimpl.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Controller
@RequestMapping("accessory")
public class AccessoryController {
    @Autowired
    AccessoryService accessoryService;
    @RequestMapping("index")
    public String index(){
        return "/accessory/accessoryHome";
    }
    @RequestMapping("home")
    public String home(){
        return "/home";
    }

    @RequestMapping("/list.action")
    public String list(Model model, Accessory accessory){
        List<Accessory> accessoryList = accessoryService.find(accessory);
        model.addAttribute("fruitId",accessory.getFruitId());
        model.addAttribute("list",accessoryList.size()<1?null:accessoryList);
        //计算附属品总价格并封装至model中
        model.addAttribute("sumPrice",SumPrice(accessoryList));
        return "accessory/accessoryHome";//转向首页
    }

    private double SumPrice(List<Accessory> accessoryList){
        double sum = 0.0;
        for(Accessory accessory:accessoryList){
            sum+=accessory.getPrice();
        }
        return sum;
    }
    @RequestMapping("/add.action")
    public String add(Model model,Accessory accessory){
        accessory.setAccessoryId(UUID.randomUUID().toString());
        accessory.setFruitId(accessory.getFruitId());
        accessory.setCreateTime(new Date());
        accessoryService.insert(accessory);
        //重新刷新列表
        return "redirect:/accessory/list.action?fruitId="+accessory.getFruitId();
    }

    //删除一个
    @RequestMapping("/delete.action")
    public String delete(Model model,Accessory accessory){
        accessoryService.deleteById(accessory.getAccessoryId());
        //重新刷新列表
      return "redirect:/accessory/list.action?fruitId="+accessory.getFruitId();
    }

    //批量删除
    @RequestMapping("/deleteList.action")
    public String deleteList(Model model,String [] arrays,Accessory accessory){
        accessoryService.delete(arrays);
        //重新刷新列表
        return "redirect:/accessory/list.action?fruitId="+accessory.getFruitId();
    }

}
