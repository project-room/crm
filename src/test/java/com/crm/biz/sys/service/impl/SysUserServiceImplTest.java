package com.crm.biz.sys.service.impl;

import com.crm.common.Page;
import com.crm.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysUserServiceImplTest {
    @Autowired
    private MockMvc mockMvc;
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
    public void selectSysUserInfoById() throws Exception {
      SysUser sysUser= sysUserService.selectSysUserInfoById(1L);
        System.out.println("fjskf");
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("hello world")));
    }
}