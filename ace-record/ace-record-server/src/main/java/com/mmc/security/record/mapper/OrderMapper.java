package com.mmc.security.record.mapper;

import com.mmc.security.record.entity.Order;
import com.mmc.security.record.vo.MonthReportVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-19 23:20
 **/

public interface OrderMapper extends Mapper<Order> {

    /**
     * 获取最近7哥月的金额汇总
     * @return
     */
    List<MonthReportVO> getMonthReport();
}
