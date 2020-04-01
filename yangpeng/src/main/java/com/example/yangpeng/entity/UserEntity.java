package com.example.yangpeng.entity;

import java.util.Date;

public class UserEntity {
    private String idUser;

    private String accountUser;

    private Integer phoneUser;

    private String emailUser;

    private String passwordUser;

    private Date createTimeUser;

    private String addressUser;

    private Date lastLoginTimeUser;

    private String imgUser;

    private String ipUser;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser == null ? null : accountUser.trim();
    }

    public Integer getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(Integer phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser == null ? null : emailUser.trim();
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser == null ? null : passwordUser.trim();
    }

    public Date getCreateTimeUser() {
        return createTimeUser;
    }

    public void setCreateTimeUser(Date createTimeUser) {
        this.createTimeUser = createTimeUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser == null ? null : addressUser.trim();
    }

    public Date getLastLoginTimeUser() {
        return lastLoginTimeUser;
    }

    public void setLastLoginTimeUser(Date lastLoginTimeUser) {
        this.lastLoginTimeUser = lastLoginTimeUser;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser == null ? null : imgUser.trim();
    }

    public String getIpUser() {
        return ipUser;
    }

    public void setIpUser(String ipUser) {
        this.ipUser = ipUser == null ? null : ipUser.trim();
    }
}