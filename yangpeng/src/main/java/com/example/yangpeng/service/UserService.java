package com.example.yangpeng.service;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.utils.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    Page<Map<String, Object>> getUserList(Integer pageSize, Integer pageNumber);
}
