package com.mmc.security.admin.mapper;

import com.mmc.security.admin.entity.Role;
import com.mmc.security.admin.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

     void deleteRoleMembersById (@Param("roleId") int roleId);
     void insertRoleMembersById (@Param("roleId") int roleId,@Param("userId") int userId);
     List<User> selectUsersByRole(@Param("roleId") int roleId);
}
