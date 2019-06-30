package com.mmc.security.record.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 经期记录
 * @author: mmc
 * @create: 2019-06-23 15:01
 **/
@Table(name = "menstruation")
@Data
@EqualsAndHashCode(callSuper = false)
public class Menstruation extends BaseBean{

    @Id
    private Integer id;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date mensDate;

    //周期
    private Integer cycle;
}
