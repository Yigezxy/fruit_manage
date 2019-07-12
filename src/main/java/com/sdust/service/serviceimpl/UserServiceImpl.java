package com.sdust.service.serviceimpl;

import com.sdust.entity.ResultInfo;
import com.sdust.entity.User;
import com.sdust.mapper.UserMapper;
import com.sdust.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    public ResultInfo searchAll() {
        List<User> users=userMapper.searchAll();
        return new ResultInfo(1, users);
    }
}

