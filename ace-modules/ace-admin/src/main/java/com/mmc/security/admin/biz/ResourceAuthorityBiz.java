package com.mmc.security.admin.biz;

import com.mmc.security.admin.entity.ResourceAuthority;
import com.mmc.security.admin.mapper.ResourceAuthorityMapper;
import com.mmc.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ace on 2017/6/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
