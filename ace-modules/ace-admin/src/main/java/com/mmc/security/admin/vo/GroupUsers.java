package com.mmc.security.admin.vo;

import com.mmc.security.admin.entity.User;
import com.mmc.security.admin.entity.User;

import java.util.List;


public class GroupUsers {
    List<User> members ;

    public GroupUsers() {
    }

    public GroupUsers(List<User> members) {
        this.members = members;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }


}
