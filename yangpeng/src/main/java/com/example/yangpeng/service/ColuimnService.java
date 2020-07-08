package com.example.yangpeng.service;

import com.example.yangpeng.entity.ColuimnEntity;
import com.example.yangpeng.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @program: yangpeng
 * @description
 * @author: YouName
 * @create: 2020-06-04 15:26
 **/
public interface ColuimnService {
    Integer insertColuimn(ColuimnEntity coluimnEntity);

    ColuimnEntity getColuimnById(String coluimnId);

    Integer examineByColuimnId(String idColuimn,Integer statusColumn);

    Page<Map<String, Object>> listColuimnById(String parentLevelColumn, Integer pageSize , Integer pageNumber,int statusColumn);


}
