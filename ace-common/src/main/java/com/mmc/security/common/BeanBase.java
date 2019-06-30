package com.mmc.security.common;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:基类父类
 * @author: mmc
 * @create: 2019-05-31 21:05
 **/
@Data
public class BeanBase {
    @Id
    private Integer id;
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
