package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.LogEntity;

public interface LogEntityMapper {
    int insert(LogEntity record);

    int insertSelective(LogEntity record);
}