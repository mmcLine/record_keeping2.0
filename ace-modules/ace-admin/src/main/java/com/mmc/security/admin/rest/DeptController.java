package com.mmc.security.admin.rest;
import com.mmc.security.admin.biz.DeptBiz;
import com.mmc.security.admin.vo.DeptVO;
import com.mmc.security.common.msg.TableResultResponse;
import com.mmc.security.common.rest.BaseController;
import com.mmc.security.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: mmc
 * @create: 2019-06-01 21:42
 **/
@RestController
@RequestMapping("dept")
public class DeptController  extends BaseController<DeptBiz,DeptVO> {

    @Autowired
    private DeptBiz deptBiz;

    @ResponseBody
    public TableResultResponse<DeptVO> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return  deptBiz.selectByQuery(query);
    }
}
