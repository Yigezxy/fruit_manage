package com.sdust.controller;

import com.sdust.entity.ResultInfo;
import com.sdust.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("searchAll")
    public ResultInfo searchAll(){//http://localhost:8080/user/searchAll
        return userService.searchAll();
    }

    @RequestMapping("jsp")
    public ModelAndView jsp(){//设置了前缀是/WEB-INF/pages/ 后缀是.jsp
        ModelAndView mv=new ModelAndView("ceshi");
        mv.addObject("ceshi",666);
        return mv;
    }
}
