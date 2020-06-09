package com.example.yangpeng.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "栏目")
public class ColuimnEntity {

    private String idColuimn;

    private Integer statusColumn;

    @ApiModelProperty(value = "栏目名", name = "nameColumn", required = true, example = "xx栏目")
    @NotBlank(message = "栏目名不允许为空,请输入")
    private String nameColumn;

    private Integer levelColumn;

    @ApiModelProperty(value = "导航图", name = "bannerColumn", required = true, example = "xxx.com")
    @NotBlank(message = "导航图不允许为空,请输入")
    private String bannerColumn;

    @ApiModelProperty(value = "显示顺序", name = "displayOrderColumn", required = true, example = "1")
    @NotBlank(message = "导航图不允许为空,请输入")
    private Integer displayOrderColumn;

    @ApiModelProperty(value = "栏目介绍", name = "describeColumn", required = true, example = "xx栏目介绍")
    @NotBlank(message = "导航图不允许为空,请输入")
    private String describeColumn;

    private String  ParentLevelColumn;

}