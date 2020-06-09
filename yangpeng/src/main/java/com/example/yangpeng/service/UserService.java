package com.example.yangpeng.service;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.utils.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    //查询用户类表
    Page<Map<String, Object>> getUserList(Integer pageSize, Integer pageNumber);

    //创建用户
    Integer insertUser(UserEntity userEntity);
    //查询用户
    Map<String, Object> getUserByAccount(Map<String,String> params);
    //验证randomCode
    boolean verifyRandomCode(String newLink);
    //修改密码
    boolean updateUser(String userName, String password);
}
