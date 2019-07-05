package com.mmc.security.record.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 订单
 * @author: mmc
 * @create: 2019-06-19 23:10
 **/
@Table(name = "trade_order")
@Data
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseBean{

    @Id
    private Integer id;

    private String name;

    private BigDecimal amt;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @OrderBy(value = "desc")
    private Date tradeDate;

    private Integer tradeType;

    @Transient
    private String tradeTypeName;

    private String remarks;


}
