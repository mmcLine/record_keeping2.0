package com.mmc.security.record.biz;

import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.record.entity.TradeType;
import com.mmc.security.record.mapper.TradeTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-22 10:15
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TradeTypeBiz extends BaseBiz<TradeTypeMapper,TradeType> {
}
