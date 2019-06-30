package com.mmc.security.record.mapper;

import com.mmc.security.record.entity.Menstruation;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-19 23:20
 **/

public interface MenstruationMapper extends Mapper<Menstruation> {

    /**
     * 获取最后一个日期的记录
     * @return
     */
    Menstruation getLastMenstruation();
}
