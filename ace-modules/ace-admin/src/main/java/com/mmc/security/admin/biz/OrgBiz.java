package com.mmc.security.admin.biz;


import com.mmc.security.admin.entity.Org;
import com.mmc.security.admin.mapper.OrgMapper;
import com.mmc.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-01 15:38
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgBiz extends BaseBiz<OrgMapper,Org> {
}
