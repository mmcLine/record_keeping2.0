package com.mmc.security.auth.client.fallback;

import com.mmc.security.auth.client.feign.IUserOrgService;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mmc
 * @create 2019/06/29
 */
@Service
@Slf4j
public class IUserOrgServiceFallback implements IUserOrgService {

    @Override
    public UserOrgInfo getUserOrg(Integer id) {
        log.error("调用{}异常{}","getUserOrg",id);
        return null;
    }
}
