package com.mmc.security.admin.rest;


import com.mmc.security.admin.biz.OrgBiz;
import com.mmc.security.admin.entity.Org;
import com.mmc.security.common.rest.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author mmc
 * @create 2019-06-01 15:04
 */
@RestController
@RequestMapping("org")
public class OrgController extends BaseController<OrgBiz,Org> {

}
