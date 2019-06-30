package com.mmc.security.api.vo.enums;

/**
 * @description: 权限类型
 * @author: mmc
 * @create: 2019-06-13 18:15
 **/

public enum PowerGroup {

    USER_POWER(1,"用户管理员"),
    DEPT_POWER(3,"部门管理员"),
    ORG_POWER(5,"机构管理员"),
    ADMIN_POWER(99,"超级管理员");


    private Integer id;
    private String name;

    PowerGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
