package com.sdust.service;

import com.sdust.entity.ResultInfo;
import com.sdust.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11 0011.
 */
public interface UserService {
    ResultInfo searchAll();

    List<User> find(User user);

    void insert(User user);

    List<User> findByName(User user);
}
