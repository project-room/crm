package com.crm.biz.sys.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface SysUserMapper {
    SysUser findById(Long id);

    int addSysUser(SysUser sysUser);

    int deleteById(Long id);

    int updateSysUserById(SysUser sysUser);

    SysUser findByAccount(String account);

    //通过用户名获取用户Id
    Long selectUserIdByUserName(@Param("userName") String userName);

    //根据用户名和密码登录
    SysUser loginAccountAndUserName(@Param("account") String account,@Param("password") String password);

    //根据用户手机号码来获取用户
    SysUser selectSysUserByPhone(@Param("phone") String phone);

    //根据用户id来获取用户和角色信息
    SysUser selectSysUserAndRoleInfoBySysUserId(Long sysUserId);

    //获取用户列表
    List<SysUser> selectSysUserList(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    //添加员工
    void addSysUserInfo(SysUser sysUser);

    //用户总记录条数
    Long getCounts();

    //根据用户名或账号获取用户的集合
    List<SysUser> selectSysUserByUserNameOrAccount(@Param("userNameOrAccount") String userNameOrAccount,@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    //根据用户名或账号获取用户总记录条数
    Long  selectCountByUserNameOrAccount(@Param("userNameOrAccount") String userNameOrAccount);

    //根据用户id获取用户信息
    SysUser selectSysUserById(Long userId);
}