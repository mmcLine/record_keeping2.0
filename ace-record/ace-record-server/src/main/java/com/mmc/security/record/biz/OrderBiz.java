package com.mmc.security.record.biz;

import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.common.msg.TableResultResponse;
import com.mmc.security.common.util.Query;
import com.mmc.security.record.entity.Order;
import com.mmc.security.record.entity.TradeType;
import com.mmc.security.record.mapper.OrderMapper;
import com.mmc.security.record.mapper.TradeTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-19 23:26
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderBiz extends BaseBiz<OrderMapper,Order> {

    @Autowired
    private TradeTypeMapper tradeTypeMapper;


    @Override
    public void extension(List<Order> list){
        List<TradeType> typeList = tradeTypeMapper.selectAll();
        for (Order order:list){
           for (TradeType tradeType:typeList){
               if(tradeType.getId().equals(order.getTradeType())){
                   order.setTradeTypeName(tradeType.getTypeName());
               }
           }
        }
    }


}
