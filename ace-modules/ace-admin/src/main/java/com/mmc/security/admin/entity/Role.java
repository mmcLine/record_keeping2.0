package com.mmc.security.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 角色表
 * @author: mmc
 * @create: 2019-05-27 18:14
 **/

@Table(name = "base_role")
@Data
public class Role {
    @Id
    private Integer id;

    private String name;

    private String remarks;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "upd_user")
    private String updUser;

}
