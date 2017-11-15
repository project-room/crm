package com.crm.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public class SysRole {
    private Long roleId;
    private String roleName;
    private String roleDesc;
    //状态：0删除，1正常
    private Integer roleFlag;
    //一个角色对应多个权限
    private List<SysRight> sysRights;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(Integer roleFlag) {
        this.roleFlag = roleFlag;
    }

    public List<SysRight> getSysRights() {
        return sysRights;
    }

    public void setSysRights(List<SysRight> sysRights) {
        this.sysRights = sysRights;
    }
}
