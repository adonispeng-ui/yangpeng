package com.example.yangpeng.mapper;

import com.example.yangpeng.entity.CommentEntity;

public interface CommentEntityMapper {
    int deleteByPrimaryKey(String idComment);

    int insert(CommentEntity record);

    int insertSelective(CommentEntity record);

    CommentEntity selectByPrimaryKey(String idComment);

    int updateByPrimaryKeySelective(CommentEntity record);

    int updateByPrimaryKey(CommentEntity record);
}