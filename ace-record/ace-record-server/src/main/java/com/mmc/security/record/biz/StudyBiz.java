package com.mmc.security.record.biz;

import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.record.entity.Study;
import com.mmc.security.record.mapper.StudyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-23 14:05
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class StudyBiz  extends BaseBiz<StudyMapper,Study> {
}
