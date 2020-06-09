package com.example.yangpeng.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentEntity {
    private String idComment;

    private String idArticle;

    private String idColuimn;

    private String userIdComment;

    private String userContentComment;

    private String accountUserId;

    private Integer statusComment;

    private Integer checkState;


}