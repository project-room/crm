package com.crm.biz.sys.service;

import com.crm.common.Page;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;

import java.util.List;

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

    //根据用户手机号码来获取用户
    SysUser selectSysUserByUserPhone(String userPhone);

    //根据id查询角色
    SysRole selectRoleById(Long roleId);

    //添加员工
    void addSysUserBySysUserAndSysRole(SysUser sysUser,SysRole sysRole);

    //获取用户的分页
    Page<SysUser> getSysUserPage(Integer currentPage,Integer pageSize);

    //根据用户名或账号获取用户分页
    Page<SysUser> selectSysUserPageByUserNameAndAccount(String userNameOrAccount,Integer currentPage,Integer pageSize);

    //根据用户id获取用户信息
    SysUser selectSysUserInfoById(Long userId);

    //根据账号来获取用户
    SysUser selectSysUserByAccounts(String accounts);

    //加载销售经理列表
   List<SysUser> loadSalesManager(Long roleId);

   //加载销售员列表
   List<SysUser> bySysUserList(Long roleId,String district);

   //修改个人资料
   void updatePersonDataById(SysUser sysUser);
}


