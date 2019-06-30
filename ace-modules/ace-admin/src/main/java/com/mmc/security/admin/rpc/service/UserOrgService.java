package com.mmc.security.admin.rpc.service;

import com.mmc.security.admin.biz.UserBiz;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户机构查询实现类
 * @author: mmc
 * @create: 2019-06-28 18:03
 **/
@Service
public class UserOrgService{

    @Autowired
    private UserBiz userBiz;

   public UserOrgInfo getUserOrg(Integer id){
       return userBiz.getUserOrgById(id);
    }
}
