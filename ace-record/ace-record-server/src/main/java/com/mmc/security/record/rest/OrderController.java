package com.mmc.security.record.rest;

import com.mmc.security.common.rest.BaseController;
import com.mmc.security.record.biz.OrderBiz;
import com.mmc.security.record.entity.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-19 23:19
 **/
@RestController
@RequestMapping("order")
public class OrderController  extends BaseController<OrderBiz,Order> {

}
