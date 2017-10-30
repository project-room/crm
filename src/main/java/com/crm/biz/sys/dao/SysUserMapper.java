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
}