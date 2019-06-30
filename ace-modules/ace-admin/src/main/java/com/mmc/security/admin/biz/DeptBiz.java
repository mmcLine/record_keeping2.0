package com.mmc.security.admin.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mmc.security.admin.entity.Dept;
import com.mmc.security.admin.mapper.DeptMapper;
import com.mmc.security.admin.vo.DeptVO;
import com.mmc.security.common.biz.BaseBiz;
import com.mmc.security.common.msg.TableResultResponse;
import com.mmc.security.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-01 21:41
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DeptBiz extends BaseBiz<DeptMapper,Dept> {

    @Autowired
    private DeptMapper deptMapper;

    public TableResultResponse selectByQuery(Query query) {
        String deptName=null;
        if(query.entrySet().size()>0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                deptName=entry.getValue().toString();
            }
        }
        Dept dept=new Dept();
        dept.setDeptName(deptName);
        int count = mapper.selectCount(dept);

        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<DeptVO> list = deptMapper.listByQuery(deptName);
        return new TableResultResponse<DeptVO>(Long.valueOf(count), list);
    }
}
