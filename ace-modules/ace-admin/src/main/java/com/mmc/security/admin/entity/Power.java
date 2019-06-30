package com.mmc.security.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 权限表
 * @author: mmc
 * @create: 2019-05-27 18:18
 **/

@Table(name = "power")
public class Power {

    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "dept_id")
    private Integer deptId;
}
