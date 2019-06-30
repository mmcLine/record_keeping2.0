package com.mmc.security.record.rest;

import com.mmc.security.common.rest.BaseController;
import com.mmc.security.record.biz.MenstruationBiz;
import com.mmc.security.record.entity.Menstruation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-23 15:24
 **/
@RestController
@RequestMapping("menstruation")
public class MenstruationController extends BaseController<MenstruationBiz,Menstruation> {
}
