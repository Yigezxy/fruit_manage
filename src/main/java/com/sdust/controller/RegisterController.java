package com.sdust.controller;

import com.sdust.entity.Shopper;
import com.sdust.service.serviceimpl.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    ShopperService shopperService;
    @RequestMapping("register")
    public ModelAndView register(){
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("ceshi",666);
        return mv;
    }

    @PostMapping("/html/register")
    public String Register(HttpServletRequest req, Shopper user,Model model)
    {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPhonenumber());
        System.out.println(user.getUsername());
        String rePassword = req.getParameter("repassword");
        System.out.println(rePassword);
        user.setId(UUID.randomUUID().toString());
        String s = shopperService.inster(user);
        model.addAttribute("registerInfo",s);
        if (s.equals("注册成功")){
            return "/shop/html/register";
        }else{
            return "/shop/html/register";
        }

    }
    @GetMapping("/html/register")
    public String GetRegister(){
        return "/shop/html/register";
    }


}
