package com.sdust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Cierlly on 7/12/2019.
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    @RequestMapping("register")
    public ModelAndView register(){
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("ceshi",666);
        return mv;
    }


}
