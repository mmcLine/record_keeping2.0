package com.mmc.security.record.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 月报表
 * @author: mmc
 * @create: 2019-07-06 08:22
 **/

@Data
public class MonthReportVO {

    private String month;
    private BigDecimal totalamt;
}
