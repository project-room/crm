package com.crm.controller;

import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.SysUser;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping("/login")
    public Map login(String userName,String userPassword){
        Map map= TypeUtil.successMap();
       SysUser sysUser= sysUserService.login(userName,userPassword);
        session.setAttribute("sysUser",sysUser);
       map.put("login",sysUser);
       return map;
    }

    @RequestMapping("/logout")
    public Map logout(){
        Map map=TypeUtil.successMap();
        session.setAttribute("sysUser",null);
        return map;
    }
}
