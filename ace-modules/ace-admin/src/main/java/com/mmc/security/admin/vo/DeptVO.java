package com.mmc.security.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-02 09:41
 **/
@Data
public class DeptVO {

    @Id
    private Integer id;

    private String deptCode;

    private String deptName;

    private Integer orgId;

    @Column(name = "crt_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "upd_user")
    private String updUser;

    private String orgName;
}
