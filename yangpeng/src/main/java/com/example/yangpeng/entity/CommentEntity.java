package com.example.yangpeng.entity;

public class CommentEntity {
    private String idComment;

    private String idArticle;

    private String idColuimn;

    private String userIdComment;

    private String userContentComment;

    private String accountUserId;

    private Integer statusComment;

    private Integer checkState;

    public String getIdComment() {
        return idComment;
    }

    public void setIdComment(String idComment) {
        this.idComment = idComment == null ? null : idComment.trim();
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

    public String getUserIdComment() {
        return userIdComment;
    }

    public void setUserIdComment(String userIdComment) {
        this.userIdComment = userIdComment == null ? null : userIdComment.trim();
    }

    public String getUserContentComment() {
        return userContentComment;
    }

    public void setUserContentComment(String userContentComment) {
        this.userContentComment = userContentComment == null ? null : userContentComment.trim();
    }

    public String getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(String accountUserId) {
        this.accountUserId = accountUserId == null ? null : accountUserId.trim();
    }

    public Integer getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(Integer statusComment) {
        this.statusComment = statusComment;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }
}