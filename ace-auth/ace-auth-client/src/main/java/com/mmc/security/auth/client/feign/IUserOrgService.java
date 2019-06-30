package com.mmc.security.auth.client.feign;


import com.mmc.security.auth.client.fallback.IUserOrgServiceFallback;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 用户组织机构接口
 * @author: mmc
 * @create: 2019-06-28 15:14
 **/
@FeignClient(value = "ace-admin",fallback = IUserOrgServiceFallback.class)
public interface IUserOrgService {

    @RequestMapping(value = "/api/user/userorg", method = RequestMethod.GET)
    UserOrgInfo getUserOrg(@RequestParam("id") Integer id);
}
