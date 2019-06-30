package com.mmc.security.admin.mapper;

import com.mmc.security.admin.entity.User;
import com.mmc.security.admin.vo.UserVO;
import com.mmc.security.auth.client.vo.UserOrgInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public List<User> selectMemberByGroupId(@Param("roleId") int roleId);
    public List<User> selectLeaderByGroupId(@Param("roleId") int roleId);
    List<UserVO> listByQuery(@Param("userName") String userName);
    Integer conutByQuery(@Param("userName") String userName);

    /**
     * 获取用户部门机构
     * @param id
     * @return
     */
    UserOrgInfo getUserOrgById(Integer id);
}