package com.example.yangpeng.entity;

public class ColuimnEntity {
    private String idColuimn;

    private Integer statusColumn;

    private String nameColumn;

    private Integer levelColumn;

    private String bannerColumn;

    private Integer displayOrderColumn;

    private String describeColumn;

    public String getIdColuimn() {
        return idColuimn;
    }

    public void setIdColuimn(String idColuimn) {
        this.idColuimn = idColuimn == null ? null : idColuimn.trim();
    }

    public Integer getStatusColumn() {
        return statusColumn;
    }

    public void setStatusColumn(Integer statusColumn) {
        this.statusColumn = statusColumn;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn == null ? null : nameColumn.trim();
    }

    public Integer getLevelColumn() {
        return levelColumn;
    }

    public void setLevelColumn(Integer levelColumn) {
        this.levelColumn = levelColumn;
    }

    public String getBannerColumn() {
        return bannerColumn;
    }

    public void setBannerColumn(String bannerColumn) {
        this.bannerColumn = bannerColumn == null ? null : bannerColumn.trim();
    }

    public Integer getDisplayOrderColumn() {
        return displayOrderColumn;
    }

    public void setDisplayOrderColumn(Integer displayOrderColumn) {
        this.displayOrderColumn = displayOrderColumn;
    }

    public String getDescribeColumn() {
        return describeColumn;
    }

    public void setDescribeColumn(String describeColumn) {
        this.describeColumn = describeColumn == null ? null : describeColumn.trim();
    }
}