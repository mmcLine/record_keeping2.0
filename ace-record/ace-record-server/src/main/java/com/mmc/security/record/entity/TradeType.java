package com.mmc.security.record.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 交易类型
 * @author: mmc
 * @create: 2019-06-22 10:12
 **/
@Table(name = "trade_type")
@Data
@EqualsAndHashCode(callSuper = false)
public class TradeType extends BaseBean{

    @Id
    private Integer id;

    //交易类型
    private String typeName;

}
