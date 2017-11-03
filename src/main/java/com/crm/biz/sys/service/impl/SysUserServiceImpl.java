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

    public SysUser login(String account,String password){
//        SysUser byAccount = sysUserMapper.findByAccount(account);
//        if(byAccount != null){
//            //密码判断，到时候要进行加密
//            if(byAccount.getUserPassword().equals(password)){
//                return byAccount;
//            }
//        }
//        return null;
        return  sysUserMapper.loginAccountAndUserName(account,password);
    }

    public int register(SysUser sysUser){
        SysUser byAccount = sysUserMapper.findByAccount(sysUser.getUserAccounts());
        if(byAccount == null){
             return sysUserMapper.addSysUser(sysUser);
        }else{
            //帐号已经存在
        }
        return 0;
    }

    public int deleteById(Long userId){
        return sysUserMapper.deleteById(userId);
    }

    public int updateSysUserById(SysUser sysUser){
        return sysUserMapper.updateSysUserById(sysUser);
    }

    @Override
    public Long selectUserIdByUserName(String userName) {
        Long userId=null;
        userId=sysUserMapper.selectUserIdByUserName(userName);
        return userId;
    }


}
