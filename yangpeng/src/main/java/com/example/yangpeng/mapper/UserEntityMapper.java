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
    //用户名取id
    String getUserByAccount(String userIdByAccount);
    //邮箱取id
    String getUserByMail(String userIdBymail);
    //手机号取id
    String getUserByPhone(String userIdByphone);
    //通过邮箱码查询是否有用户
    String verifyRandomCode(String newLink);
    //修改用户邮箱状态
    Integer updateMailstate(String userId);
}