package com.example.yangpeng.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.catalina.User;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "登录")

public class UserEntity implements Serializable {

    private String idUser;

    @ApiModelProperty(value = "账号", name = "accountUser", required = true, example = "admin")
    @NotBlank(message = "账号不允许为空,请输入")
    private String accountUser;

    @ApiModelProperty(value = "手机", name = "emailUser", required = true)
    private String phoneUser;

    @ApiModelProperty(value = "邮箱", name = "emailUser", required = true, example = "xxx@126.com")
    @NotBlank(message = "邮箱不允许为空,请输入")
    private String emailUser;

    @ApiModelProperty(value = "密码", name = "passwordUser", required = true, example = "123456")
    @NotBlank(message = "密码不允许为空,请输入")
    private String passwordUser;

    private Date createTimeUser;

    private String addressUser;

    private Date lastLoginTimeUser;

    private String imgUser;

    private String ipUser;

    private Date updateTimeUser;

    public Date getUpdateTimeUser() {
        return updateTimeUser;
    }

    public void setUpdateTimeUser(Date updateTimeUser) {
        this.updateTimeUser = updateTimeUser;
    }

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

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
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