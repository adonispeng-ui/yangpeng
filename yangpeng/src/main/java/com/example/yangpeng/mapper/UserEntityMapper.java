package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(String idUser);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String idUser);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}