package com.sdust.controller;

import com.sdust.entity.*;
import com.sdust.service.serviceimpl.ShopperService;
import org.apache.ibatis.annotations.Select;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Cierlly on 7/13/2019.
 */
@Controller
@RequestMapping("/shopper")
public class ShopController {
    @Autowired
    ShopperService shopperService;
    @RequestMapping("/zhuce")
    public String ShopRegister(){
        System.out.println("jinru");
        return "redirect:../register/html/register";
    }
    @RequestMapping("login")
    public String ShopLogin(){
        return "/shop/html/login";
    }
    @PostMapping("shop/login.in")
    public String loginIn(Shopper shopper, Model model, HttpSession session){
        System.out.println(shopper.getPhonenumber());
        System.out.println(shopper.getPassword());
        String phonenumber = shopper.getPhonenumber();
        Shopper shopper1 = shopperService.findUserByPhone(phonenumber);

        if(shopper1 != null){
            String username = shopper1.getUsername();
            System.out.println(shopper1);
            if (shopper1.getPassword().equals(shopper.getPassword())){
                model.addAttribute("loginInfo","登录成功");

                //model.addAttribute("userInfo",username);
                session.setAttribute("userInfo",username);
                session.setAttribute("shopper",shopper1);
                System.out.println("插桩测试"+username);
//                return "redirect:shop/commdity";
                List<String> stringList = shopperService.FindType();
                model.addAttribute("typeList",stringList);
                List<Commodities> commoditiesList = shopperService.FindAllFruit();
                model.addAttribute("fruitlist",commoditiesList);
                return "/shop/html/commdity";

            }
            else {
                model.addAttribute("loginInfo","密码错误");
               // model.addAttribute("userInfo",username);
                return "/shop/html/login";
            }
        }else{
            model.addAttribute("loginInfo","该手机号尚未注册");
            return "/shop/html/login";
        }
    }
    @RequestMapping("shop/commdity")
    public String ShowCommdity(Model model){

        List<Commodities> commoditiesList = shopperService.FindAllFruit();
        model.addAttribute("fruitlist",commoditiesList);
        List<String> stringList = shopperService.FindType();
        model.addAttribute("typeList",stringList);
        return "shop/html/commdity";
    }
    @GetMapping("productFindByPid.action")
    public String SelectOneFruit(String pid,Model model){
        List<Commodities> commoditiesList = shopperService.FindFruitByName(pid);
        model.addAttribute("fruitlist",commoditiesList);
        List<String> stringList = shopperService.FindType();
        model.addAttribute("typeList",stringList);
        return "shop/html/commdity";
    }

    @RequestMapping("/shop/about")
    public String ChangeAbout(){
        return "shop/html/about";
    }
    @RequestMapping("/shop/information")
    public String Changeinformation(){
        return "shop/html/information";
    }

    @GetMapping("/details")
    public String ChangeDetails(String fruitid,Model model){
        Commodities commodities = shopperService.FindFruitById(fruitid);
        model.addAttribute("onefruit",commodities);
        return "shop/html/details";
    }
    @PostMapping("/addlist.action")
    @ResponseBody
    public AddData Addlist(ShopList shopList){
        System.out.println(shopList.getShopperid());
        System.out.println(shopList.getFruitid());
        shopList.setState("nopay");
        shopList.setShopid(UUID.randomUUID().toString());
        String ss = shopperService.insertIntoShoplist(shopList);
        AddData addData = new AddData();
        addData.setMessage(ss);
        addData.setObject(shopList);
        return addData;
    }

    @RequestMapping("/shopcar")
    public String ChangeShopCar(Model model,HttpSession session){

        String ss = (String) session.getAttribute("userInfo");
        if (ss != null)
        {
            Shopper shopper = (Shopper) session.getAttribute("shopper");
            //String shopperid = shopper.getId();
           //List<ShopList>shopLists =  shopperService.selectShoplistByShopperid(shopper);
            List<ShopListVo> shopListVos = shopperService.searchVoByShopperid(shopper);
            System.out.println(shopListVos.size());
            for (ShopListVo shopListVo : shopListVos){
                System.out.println(shopListVo.getShopid());
            }
           session.setAttribute("shoplistvo",shopListVos);

            return "shop/html/shopcart";

        }
        else{
            model.addAttribute("loginInfo","想查看购物车要先登录");
            return "shop/html/login";
        }

    }

    @RequestMapping("/test")
    @ResponseBody
    public List<ShopListVo>  test(){
        return shopperService.searchVo();
    }

}
