package com.mmc.security.record.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @description: 基础实体类
 * @author: mmc
 * @create: 2019-06-19 23:17
 **/
@Data
@MappedSuperclass
public class BaseBean {

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "upd_user")
    private String updUser;

    private Integer deptId;

    private Integer orgId;
}
