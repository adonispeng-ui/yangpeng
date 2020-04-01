package com.example.yangpeng.entity;

import java.util.Date;

public class CountdownEntity {
    private String idCountdown;

    private String subjectCountdown;

    private String contentCountdown;

    private Date createTimeCountdown;

    private Date timeCountdown;

    public String getIdCountdown() {
        return idCountdown;
    }

    public void setIdCountdown(String idCountdown) {
        this.idCountdown = idCountdown == null ? null : idCountdown.trim();
    }

    public String getSubjectCountdown() {
        return subjectCountdown;
    }

    public void setSubjectCountdown(String subjectCountdown) {
        this.subjectCountdown = subjectCountdown == null ? null : subjectCountdown.trim();
    }

    public String getContentCountdown() {
        return contentCountdown;
    }

    public void setContentCountdown(String contentCountdown) {
        this.contentCountdown = contentCountdown == null ? null : contentCountdown.trim();
    }

    public Date getCreateTimeCountdown() {
        return createTimeCountdown;
    }

    public void setCreateTimeCountdown(Date createTimeCountdown) {
        this.createTimeCountdown = createTimeCountdown;
    }

    public Date getTimeCountdown() {
        return timeCountdown;
    }

    public void setTimeCountdown(Date timeCountdown) {
        this.timeCountdown = timeCountdown;
    }
}