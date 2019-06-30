package com.mmc.security.record.biz;

import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.common.util.EntityUtils;
import com.mmc.security.record.entity.Menstruation;
import com.mmc.security.record.mapper.MenstruationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-23 15:09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class MenstruationBiz extends BaseBiz<MenstruationMapper,Menstruation> {



    @Override
    public void insertSelective(Menstruation entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        Menstruation lastMenstruation = mapper.getLastMenstruation();
        Integer cycle=30;
        if(lastMenstruation!=null){
            cycle=differentDaysByMillisecond(lastMenstruation.getMensDate(),entity.getMensDate());
        }
        entity.setCycle(cycle);
        mapper.insertSelective(entity);
    }

    private static int differentDaysByMillisecond(Date startDate,Date endDate)
    {
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24));
        return days;
    }
}
