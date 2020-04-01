package com.example.yangpeng.entity;

import java.util.Date;

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

    public String getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId == null ? null : accountUserId.trim();
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle == null ? null : idArticle.trim();
    }

    public String getIdColuimn() {
        return idColuimn;
    }

    public void setIdColuimn(String idColuimn) {
        this.idColuimn = idColuimn == null ? null : idColuimn.trim();
    }

    public Integer getClickNbrArticle() {
        return clickNbrArticle;
    }

    public void setClickNbrArticle(Integer clickNbrArticle) {
        this.clickNbrArticle = clickNbrArticle;
    }

    public Date getCreateTimeArticle() {
        return createTimeArticle;
    }

    public void setCreateTimeArticle(Date createTimeArticle) {
        this.createTimeArticle = createTimeArticle;
    }

    public String getSubjectArticle() {
        return subjectArticle;
    }

    public void setSubjectArticle(String subjectArticle) {
        this.subjectArticle = subjectArticle == null ? null : subjectArticle.trim();
    }

    public String getContentArticle() {
        return contentArticle;
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle = contentArticle == null ? null : contentArticle.trim();
    }

    public Date getUpdateTimeArticle() {
        return updateTimeArticle;
    }

    public void setUpdateTimeArticle(Date updateTimeArticle) {
        this.updateTimeArticle = updateTimeArticle;
    }

    public Integer getDisplayOrderArticle() {
        return displayOrderArticle;
    }

    public void setDisplayOrderArticle(Integer displayOrderArticle) {
        this.displayOrderArticle = displayOrderArticle;
    }

    public Integer getIsTopArticle() {
        return isTopArticle;
    }

    public void setIsTopArticle(Integer isTopArticle) {
        this.isTopArticle = isTopArticle;
    }

    public Integer getEssenceArticle() {
        return essenceArticle;
    }

    public void setEssenceArticle(Integer essenceArticle) {
        this.essenceArticle = essenceArticle;
    }

    public Integer getCollectionNbrArticle() {
        return collectionNbrArticle;
    }

    public void setCollectionNbrArticle(Integer collectionNbrArticle) {
        this.collectionNbrArticle = collectionNbrArticle;
    }

    public Integer getShareNbrArticle() {
        return shareNbrArticle;
    }

    public void setShareNbrArticle(Integer shareNbrArticle) {
        this.shareNbrArticle = shareNbrArticle;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg == null ? null : showImg.trim();
    }
}