package com.crm.biz.sys.dao;

import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void selectUserIdByUserName() throws Exception {
       Long userId= sysUserMapper.selectUserIdByUserName("聂宇豪");
        System.out.println("userId:"+userId);
        Assert.assertNotNull(userId);
    }

    @Test
    public void selectSysUserByPhone(){
        SysUser sysUser=sysUserMapper.selectSysUserByPhone("13628498903");
        System.out.println("用户名："+sysUser.getUserName());
    }

    @Test
    public void selectSysUserAndRoleInfoBySysUserId(){
      SysUser sysUser= sysUserMapper.selectSysUserAndRoleInfoBySysUserId(1L);
      SysRole sysRole=sysUser.getSysRole();
        System.out.println("角色id："+sysRole.getRoleId());
        System.out.println("角色的名称："+sysRole.getRoleName());
        System.out.println("角色的描述："+sysRole.getRoleDesc());
        System.out.println("角色的状态："+sysRole.getRoleFlag());
    }

    @Test
    public void getCounts(){
       Long counts= sysUserMapper.getCounts();
        System.out.println("用户总数："+counts);
    }

}