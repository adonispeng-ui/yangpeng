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

}