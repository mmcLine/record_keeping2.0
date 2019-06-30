package com.mmc.security.admin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-05 21:56
 **/
@Data
public class UserVO {
    private Integer id;

    private String username;

    private String name;

    private String sex;

    private String description;

    private String deptname;

    private String updName;

    private Date updTime;

    //权限组
    private Integer powerGroup;
}
