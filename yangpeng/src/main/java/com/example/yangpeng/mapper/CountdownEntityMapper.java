package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.CountdownEntity;

public interface CountdownEntityMapper {
    int insert(CountdownEntity record);

    int insertSelective(CountdownEntity record);
}