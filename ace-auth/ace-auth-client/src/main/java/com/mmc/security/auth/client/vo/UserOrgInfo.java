package com.mmc.security.auth.client.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户组织机构
 * @author: mmc
 * @create: 2019-06-29 11:42
 **/

@Data
public class UserOrgInfo implements Serializable {

    private Integer userId;
    private Integer deptId;
    private Integer orgId;
    private Integer powerGroup;
}
