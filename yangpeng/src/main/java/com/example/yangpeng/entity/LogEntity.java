package com.example.yangpeng.entity;

import java.util.Date;

public class LogEntity {
    private String idLog;

    private Integer typeLog;

    private String abnormalLog;

    private Date timeLog;

    private String requestUrlLog;

    private String methodExecutionTimeLog;

    private String operatePersonLogId;

    private String ipLog;

    private Integer methodType;

    private String prarms;

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog == null ? null : idLog.trim();
    }

    public Integer getTypeLog() {
        return typeLog;
    }

    public void setTypeLog(Integer typeLog) {
        this.typeLog = typeLog;
    }

    public String getAbnormalLog() {
        return abnormalLog;
    }

    public void setAbnormalLog(String abnormalLog) {
        this.abnormalLog = abnormalLog == null ? null : abnormalLog.trim();
    }

    public Date getTimeLog() {
        return timeLog;
    }

    public void setTimeLog(Date timeLog) {
        this.timeLog = timeLog;
    }

    public String getRequestUrlLog() {
        return requestUrlLog;
    }

    public void setRequestUrlLog(String requestUrlLog) {
        this.requestUrlLog = requestUrlLog == null ? null : requestUrlLog.trim();
    }

    public String getMethodExecutionTimeLog() {
        return methodExecutionTimeLog;
    }

    public void setMethodExecutionTimeLog(String methodExecutionTimeLog) {
        this.methodExecutionTimeLog = methodExecutionTimeLog == null ? null : methodExecutionTimeLog.trim();
    }

    public String getOperatePersonLogId() {
        return operatePersonLogId;
    }

    public void setOperatePersonLogId(String operatePersonLogId) {
        this.operatePersonLogId = operatePersonLogId == null ? null : operatePersonLogId.trim();
    }

    public String getIpLog() {
        return ipLog;
    }

    public void setIpLog(String ipLog) {
        this.ipLog = ipLog == null ? null : ipLog.trim();
    }

    public Integer getMethodType() {
        return methodType;
    }

    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    public String getPrarms() {
        return prarms;
    }

    public void setPrarms(String prarms) {
        this.prarms = prarms == null ? null : prarms.trim();
    }
}