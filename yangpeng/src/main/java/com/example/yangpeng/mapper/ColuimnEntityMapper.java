package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.ColuimnEntity;

public interface ColuimnEntityMapper {
    int deleteByPrimaryKey(String idColuimn);

    int insert(ColuimnEntity record);

    int insertSelective(ColuimnEntity record);

    ColuimnEntity selectByPrimaryKey(String idColuimn);

    int updateByPrimaryKeySelective(ColuimnEntity record);

    int updateByPrimaryKey(ColuimnEntity record);
}