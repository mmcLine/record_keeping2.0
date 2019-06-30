package com.mmc.security.record.rest;

import com.mmc.security.common.rest.BaseController;
import com.mmc.security.record.biz.StudyBiz;
import com.mmc.security.record.entity.Study;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-19 23:19
 **/
@RestController
@RequestMapping("study")
public class StudyController extends BaseController<StudyBiz,Study> {

}
