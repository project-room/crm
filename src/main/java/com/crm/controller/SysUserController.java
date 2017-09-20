package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.CstCustomer;
import com.crm.entity.SysUser;
import com.crm.entity.SysUserExample;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping("/login")
    public Map login(String userName,String userPassword){
        Map map= TypeUtil.successMap();
        return map;
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("/logout")
    public Map logout(){
        Map map=TypeUtil.successMap();
        session.setAttribute("sysUser",null);
        return map;
    }

    @RequestMapping("/updateUserInfo")
    public Map updateUserInfo(SysUser sysUser){
        Map map=TypeUtil.successMap();
        sysUserService.updateUserInfo(sysUser);
        return map;
    }

    @RequestMapping("/test")
    public String test(){
        return "index.html";
    }
    @RequestMapping("/getCustomerList")
    public Map getCustomerList(Long id){
        Map map=TypeUtil.successMap();
        SysUser sysUser = sysUserService.selectCustomerList((long) 1);//这传入的参数到时候要改
        map.put("sysUserCustomerList",sysUser.getCustomerList());
        return map;
    }



}
