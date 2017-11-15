package com.crm.biz.sys.service.impl;

import com.crm.biz.sys.dao.SysRoleMapper;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.Page;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
@Primary
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

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

    @Override
    public SysUser selectSysUserByUserPhone(String userPhone) {
        return  sysUserMapper.selectSysUserByPhone(userPhone);
    }

    @Override
    public SysRole selectRoleById(Long roleId) {
      return  sysRoleMapper.selectSysRoleByIdInfo(roleId);
    }


    @Override
    public void addSysUserBySysUserAndSysRole(SysUser sysUser, SysRole sysRole) {
        //角色同时获取角色id
       String roleName= sysRole.getRoleName();
       if("管理员".equals(roleName)){
            sysUser.setRoleId(1L);
       }else if("销售经理".equals(sysRole.getRoleName())){
            sysUser.setRoleId(2L);
       }else{
           sysUser.setRoleId(3L);
       }
       sysUserMapper.addSysUserInfo(sysUser);
    }

    @Override
    public Page<SysUser> getSysUserPage(Integer currentPage,Integer pageSize) {
        int currentPageLimit=(currentPage-1)*pageSize;
       List<SysUser> sysUsers=sysUserMapper.selectSysUserList(currentPageLimit,pageSize);
       Long retotal= sysUserMapper.getCounts();
        return new Page<SysUser>(currentPage,pageSize,sysUsers,retotal) ;
    }

    @Override
    public Page<SysUser> selectSysUserPageByUserNameAndAccount(String userNameOrAccount, Integer currentPage, Integer pageSize) {
        //根据用户名或账号获取每页的用户集合
        userNameOrAccount="%"+userNameOrAccount+"%";
        currentPage=(currentPage-1)*pageSize;
        List<SysUser> sysUsers=sysUserMapper.selectSysUserByUserNameOrAccount(userNameOrAccount,currentPage,pageSize);
        //根据用户名或账号获取用户总记录条数
        Long count= sysUserMapper.selectCountByUserNameOrAccount(userNameOrAccount);
        return new Page<SysUser>(currentPage,pageSize,sysUsers,count);
    }

    @Override
    public SysUser selectSysUserInfoById(Long userId) {
        return sysUserMapper.selectSysUserById(userId);
    }


}
