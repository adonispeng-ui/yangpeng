package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.ColuimnEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ColuimnEntityMapper {
    int deleteByPrimaryKey(String idColuimn);

    int insert(ColuimnEntity record);

    int insertSelective(ColuimnEntity record);

    ColuimnEntity selectByPrimaryKey(String idColuimn);

    int updateByPrimaryKeySelective(ColuimnEntity record);

    int updateByPrimaryKey(ColuimnEntity record);

    Integer examineByColuimnId(String idColuimn,Integer statusColumn);

    List listColuimnById(Map<String, Object> params );

    Integer countColuimnById(Map<String, Object> params);
}