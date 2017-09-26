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

    void addSysUser(SysUser sysUser);

    void deleteById(Long id);

    void updateSysUserById(SysUser sysUser);

    SysUser selectIdByCstCustomer(Long id);

    SysUser loginByAccountAndPassword(@Param("account") String account,@Param("password") String password);
}