package com.crm.biz.sys.service.impl;

import com.crm.common.Page;
import com.crm.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Autowired
    private SysUserServiceImpl sysUserService;
    @Test
    public void selectSysUserPageByUserNameAndAccount(){
       Page<SysUser> sysUserPage= sysUserService.selectSysUserPageByUserNameAndAccount("周",1,3);
       List<SysUser> sysUserList= sysUserPage.getList();
        for (SysUser sysUser:sysUserList
             ) {
            System.out.println("用户的Id:"+sysUser.getUserId());
        }
    }

    @Test
    public void selectSysUserInfoById(){
      SysUser sysUser= sysUserService.selectSysUserInfoById(1L);
        System.out.println("fjskf");
    }
}