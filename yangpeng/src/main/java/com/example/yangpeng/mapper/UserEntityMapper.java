package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserEntityMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String idUser);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    Integer getUserListCount();

    List<Map<String, Object>> getUserList(Map<String, Object> params);
    //取用户名
    String getUserByAccount(String accountUser);
}