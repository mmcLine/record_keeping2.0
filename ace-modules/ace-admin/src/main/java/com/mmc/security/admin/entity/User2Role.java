package com.mmc.security.admin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 用户角色关联表
 * @author: mmc
 * @create: 2019-05-31 21:41
 **/

@Table(name = "base_user_role")
@Data
public class User2Role {
    @Id
    private Integer id;
    private Integer userId;
    private Integer roleId;

    @Column(name = "crt_time")
    private Date crtTime;
    @Column(name = "upd_time")
    private Date updTime;
}
