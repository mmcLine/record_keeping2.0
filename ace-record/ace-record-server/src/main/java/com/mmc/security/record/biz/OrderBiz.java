package com.mmc.security.record.biz;

import com.alibaba.fastjson.JSONObject;
import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.common.msg.ObjectRestResponse;
import com.mmc.security.record.entity.Order;
import com.mmc.security.record.entity.TradeType;
import com.mmc.security.record.mapper.OrderMapper;
import com.mmc.security.record.mapper.TradeTypeMapper;
import com.mmc.security.record.vo.MonthReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public ObjectRestResponse monthReport(){
        List<MonthReportVO> list = mapper.getMonthReport();
        ObjectRestResponse objectRestResponse=new ObjectRestResponse();
        List<String> monthList=new ArrayList<>();
        List<BigDecimal> amtList=new ArrayList<>();
        for (MonthReportVO vo:list){
            monthList.add(vo.getMonth());
            amtList.add(vo.getTotalamt());
        }
        JSONObject json=new JSONObject();
        json.put("month",monthList);
        json.put("amt",amtList);
        return objectRestResponse.data(json);
    }


}
