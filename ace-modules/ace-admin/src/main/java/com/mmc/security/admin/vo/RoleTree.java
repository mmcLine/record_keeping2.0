package com.mmc.security.admin.vo;


import com.mmc.security.common.vo.TreeNode;

/**
 * ${DESCRIPTION}
 *
 * @author mmc
 * @create 2019-06-09
 */
public class RoleTree extends TreeNode {
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
