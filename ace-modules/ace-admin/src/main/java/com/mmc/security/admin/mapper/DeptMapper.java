package com.mmc.security.admin.mapper;

import com.mmc.security.admin.entity.Dept;
import com.mmc.security.admin.vo.DeptVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {

    List<DeptVO> listByQuery(@Param("deptName") String deptName);
}
