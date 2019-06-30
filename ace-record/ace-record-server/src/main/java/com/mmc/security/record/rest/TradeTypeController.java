package com.mmc.security.record.rest;

import com.mmc.security.common.rest.BaseController;
import com.mmc.security.record.biz.TradeTypeBiz;
import com.mmc.security.record.entity.TradeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 交易类型控制器
 * @author: mmc
 * @create: 2019-06-22 10:17
 **/
@RestController
@RequestMapping("tradeType")
public class TradeTypeController extends BaseController<TradeTypeBiz,TradeType> {
}
