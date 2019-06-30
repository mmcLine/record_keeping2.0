package com.mmc.security.api.vo.log;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 11:18
 */
public class LogInfo implements Serializable{
    private String menu;

    private String opt;

    private String uri;

    private Long crtTime;

    private String crtUser;

    private String crtName;

    private String crtHost;

    private String body;

    public LogInfo(String menu, String option, String uri,  Date crtTime, String crtUser, String crtName, String crtHost,String body) {
        this.menu = menu;
        this.opt = option;
        this.uri = uri;
        this.crtTime = crtTime.getTime();
        this.crtUser = crtUser;
        this.crtName = crtName;
        this.crtHost = crtHost;
        this.body = body;
    }

    public LogInfo() {
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String option) {
        this.opt = option;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime.getTime();
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtName() {
        return crtName;
    }

    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    public String getCrtHost() {
        return crtHost;
    }

    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
