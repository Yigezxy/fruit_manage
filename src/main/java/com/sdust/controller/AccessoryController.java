package com.sdust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Controller
@RequestMapping("accessory")
public class AccessoryController {
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("/accessory/accessoryHome");
        return mv;
    }
    @RequestMapping("home")
    public ModelAndView home(){
        ModelAndView mv=new ModelAndView("/home");
        return mv;
    }
}
