package com.example.yangpeng.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "用户")
public class UserEntity {


    private String idUser;

    @ApiModelProperty(value = "账号", name = "accountUser", required = true, example = "admin")
    @NotBlank(message = "账号不允许为空,请输入")
    private String accountUser;

    @ApiModelProperty(value = "手机", name = "phoneUser", required = true)
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

    private Integer statePhoneUser;

    private Integer stateEmailUser;

    private String codeEmailUser;

    private String codePhoneUser;

}