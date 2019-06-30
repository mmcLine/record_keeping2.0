package com.mmc.security.admin.rest;


import com.mmc.security.admin.biz.RoleBiz;
import com.mmc.security.admin.constant.AdminCommonConstant;
import com.mmc.security.admin.entity.Role;
import com.mmc.security.admin.entity.User;
import com.mmc.security.admin.vo.AuthorityMenuTree;
import com.mmc.security.admin.vo.RoleTree;
import com.mmc.security.common.msg.ObjectRestResponse;
import com.mmc.security.common.rest.BaseController;
import com.mmc.security.common.util.TreeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author mmc
 * @create 2019-06-01 15:04
 */
@RestController
@RequestMapping("role")
public class RoleController extends BaseController<RoleBiz,Role> {

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleTree> tree(String name) {
        Example example = new Example(Role.class);
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }
        return  getTree(baseBiz.selectByExample(example), AdminCommonConstant.ROOT);
    }

    private List<RoleTree> getTree(List<Role> roles,int root) {
        List<RoleTree> trees = new ArrayList<>();
        RoleTree node = null;
        for (Role role : roles) {
            node = new RoleTree();
            node.setLabel(role.getName());
            node.setParentId(-1);
            BeanUtils.copyProperties(role, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees,root) ;
    }


    @RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifiyUsers(@PathVariable int id, String members){
        baseBiz.modifyRoleUsers(id, members);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/user", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<User>> getUsers(@PathVariable int id){
        return new ObjectRestResponse<List<User>>().rel(true).data(baseBiz.getRoleUsers(id));
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyMenuAuthority(@PathVariable  int id, String menuTrees){
        String [] menus = menuTrees.split(",");
        baseBiz.modifyAuthorityMenu(id, menus);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<AuthorityMenuTree>> getMenuAuthority(@PathVariable  int id){
        return new ObjectRestResponse().data(baseBiz.getAuthorityMenu(id)).rel(true);
    }

    @RequestMapping(value = "/{id}/authority/element/add", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse addElementAuthority(@PathVariable  int id,int menuId, int elementId){
        baseBiz.modifyAuthorityElement(id,menuId,elementId);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/authority/element/remove", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse removeElementAuthority(@PathVariable int id,int menuId, int elementId){
        baseBiz.removeAuthorityElement(id,menuId,elementId);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/authority/element", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<Integer>> getElementAuthority(@PathVariable  int id){
        return new ObjectRestResponse().data(baseBiz.getAuthorityElement(id)).rel(true);
    }


//    @RequestMapping(value = "/tree", method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoleTree> tree(String name, String roleId) {
//        if(StringUtils.isBlank(name)&&StringUtils.isBlank(roleId)) {
//            return new ArrayList<RoleTree>();
//        }
//        Example example = new Example(Group.class);
//        if (StringUtils.isNotBlank(name)) {
//            example.createCriteria().andLike("name", "%" + name + "%");
//        }
//        if (StringUtils.isNotBlank(roleId)) {
//            example.createCriteria().andEqualTo("groupType", roleId);
//        }
//        return  getTree(baseBiz.selectByExample(example), AdminCommonConstant.ROOT);
//    }

}
