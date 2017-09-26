package com.crm.biz.sys.service.impl;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
@Primary
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser login(String account, String password) {
       SysUser sysUser= sysUserMapper.loginByAccountAndPassword(account,password);
        return sysUser;
    }
}
