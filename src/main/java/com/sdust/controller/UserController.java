package com.sdust.controller;

import com.sdust.entity.ResultInfo;
import com.sdust.entity.User;
import com.sdust.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;


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
    @RequestMapping("jumpregister")
    public ModelAndView jumpRegister(){
        ModelAndView mv=new ModelAndView("register");
        return mv;
    }

    @RequestMapping("/toLogin.action")
    public String toLogin() {
        return "login";//转向登录页面
    }

    //跳转至注册页面
    @RequestMapping("/registerPage.action")
    public String toRegister() {
        return "register";//转向登录页面
    }

    //列表
    @RequestMapping("/login.action")
    public String login(User user, Model model, HttpServletRequest request) {
        List<User> userList = userService.find(user);
        if (userList != null && userList.size() > 0) {
            request.getSession().setAttribute("user", userList.get(0));
            return "home";//转向主页
        }
        model.addAttribute("errorMsg", "登录失败！账号或密码错误！");//错误消息
        return "login";//转向登录页面
    }

    //注册
    @RequestMapping("/register.action")
    public String register(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查找账号是否已被注册【根据用户名】
        List<User> userList = userService.findByName(user);
        if (userList != null && userList.size() > 0) {
            //如果查询到了，说明账号已被注册，提示用户，并转发回注册页面
            model.addAttribute("errorMsg", "注册失败，用户名已被占用！");
            return "register";
        }
        user.setUserId(UUID.randomUUID().toString());//为用户设置UUID主键
        userService.insert(user);
        model.addAttribute("noticeMsg", "注册成功！请输入账号密码登录");//错误消息
        return "login";//转向登录页面
    }
}
