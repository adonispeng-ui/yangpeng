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
public class CountdownEntity {
    private String idCountdown;

    private String subjectCountdown;

    private String contentCountdown;

    private Date createTimeCountdown;

    private Date timeCountdown;


}