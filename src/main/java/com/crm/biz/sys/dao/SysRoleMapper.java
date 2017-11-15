package com.crm.biz.sys.dao;

import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface SysRoleMapper {
    SysRole selectSysRoleById(Long roleId);

    //根据角色id查询用户信息Info
    SysRole selectSysRoleByIdInfo(Long roleId);


}