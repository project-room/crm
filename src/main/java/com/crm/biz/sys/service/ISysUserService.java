package com.crm.biz.sys.service;

import com.crm.entity.SysUser;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ISysUserService {

    SysUser login(String account,String password);

    int register(SysUser sysUser);

    int deleteById(Long userId);

    int updateSysUserById(SysUser sysUser);

    //通过用户名获取用户Id
    Long selectUserIdByUserName(String userName);
}
