package com.crm.biz.sys.dao;

import com.crm.entity.SysRight;
import com.crm.entity.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleMapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Test
    public void selectSysRoleById(){
       SysRole sysRole= sysRoleMapper.selectSysRoleById(1L);
       List<SysRight> sysRights= sysRole.getSysRights();
        for (SysRight sysRight:sysRights
             ) {
            System.out.println("权限的ID:"+sysRight.getRightId()+"权限的名称："+sysRight.getRightText()+"权限的url:"+sysRight.getRightUrl());
        }
    }
}