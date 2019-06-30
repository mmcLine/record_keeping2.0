package com.mmc.security.admin.rpc;

import com.ace.cache.annotation.Cache;
import com.mmc.security.admin.rpc.service.PermissionService;
import com.mmc.security.admin.rpc.service.UserOrgService;
import com.mmc.security.api.vo.authority.PermissionInfo;
import com.mmc.security.api.vo.user.UserInfo;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("api")
public class UserRest {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserOrgService userOrgService;

    @Cache(key="permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody
    List<PermissionInfo> getAllPermission(){
        return permissionService.getAllPermission();
    }

    @Cache(key="permission:u{1}")
    @RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username){
        return permissionService.getPermissionByUsername(username);
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    public @ResponseBody UserInfo validate(@RequestBody Map<String,String> body){
        return permissionService.validate(body.get("username"),body.get("password"));
    }

    @RequestMapping(value = "/user/userorg", method = RequestMethod.GET)
    public @ResponseBody
    UserOrgInfo getUserOrg(@RequestParam("id") Integer id){
        return userOrgService.getUserOrg(id);
    }

}
