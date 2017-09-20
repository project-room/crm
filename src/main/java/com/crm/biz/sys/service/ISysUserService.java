package com.crm.biz.sys.service;

import com.crm.entity.SysUser;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ISysUserService {
    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public SysUser login(String userName, String password);

    /**
     * 修改用户信息
     * @param sysUser
     */
    public void updateUserInfo(SysUser sysUser);

    /***
     * 插入用户信息
     */
    public void insertUserInfo(SysUser sysUser);

    /***
     * 查询客户信息
     */
    public SysUser selectCustomerList(Long userId);

}
