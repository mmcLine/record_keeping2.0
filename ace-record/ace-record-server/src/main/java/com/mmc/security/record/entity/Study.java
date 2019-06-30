package com.mmc.security.record.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 学习记录
 * @author: mmc
 * @create: 2019-06-23 13:56
 **/
@Table(name = "study")
@Data
@EqualsAndHashCode(callSuper = false)
public class Study extends BaseBean{

    @Id
    private Integer id;

    //学习内容
    private String studyContent;

    //要完成的目标
    private String aim;

    //开始学习日期
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date startDate;

    //预计完成日期
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date endDate;

    //实际完成日期
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date achieveDate;

    //完成情况
    private String result;


}
