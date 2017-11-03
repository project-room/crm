package com.crm.biz.sys.dao;

import com.crm.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}