package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.ArticleEntity;

public interface ArticleEntityMapper {
    int deleteByPrimaryKey(String accountUserId);

    int insert(ArticleEntity record);

    int insertSelective(ArticleEntity record);

    ArticleEntity selectByPrimaryKey(String accountUserId);

    int updateByPrimaryKeySelective(ArticleEntity record);

    int updateByPrimaryKey(ArticleEntity record);
}