package com.example.yangpeng.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ArticleEntity {
    private String accountUserId;

    private String idArticle;

    private String idColuimn;

    private Integer clickNbrArticle;

    private Date createTimeArticle;

    private String subjectArticle;

    private String contentArticle;

    private Date updateTimeArticle;

    private Integer displayOrderArticle;

    private Integer isTopArticle;

    private Integer essenceArticle;

    private Integer collectionNbrArticle;

    private Integer shareNbrArticle;

    private String showImg;


}