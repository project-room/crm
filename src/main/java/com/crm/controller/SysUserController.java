package com.crm.controller;

import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.SysDynamic;
import com.crm.entity.SysUser;
import com.crm.utils.TypeUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class SysUserController extends BaseController {
    @Autowired
    private SysUserMapper sysUserMappers;
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("selectSysUserById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        SysUser sysUser=sysUserMappers.findById(1l);
        map.put("sysUser",sysUser);
        return map;
    }

    @RequestMapping("selectIdByCstCustomer")
    public Map selectIdByCstCustomer(){
        Map map=TypeUtil.successMap();
      SysUser sysUser=  sysUserMappers.selectIdByCstCustomer(1l);
      map.put("sysUser",sysUser);
        return map;
    }

    /**
     * 用户账号和密码登录
     * @return
     */
    @RequestMapping("login")
    public Map login(){
        Map map=TypeUtil.successMap();
       SysUser sysUser= sysUserService.login("123","123");
       request.getSession().setAttribute("sysUser",sysUser);
       map.put("sysUser",sysUser);
        return map;
    }

    /**
     * 用户退出登录
     * @return
     */
    public Map loginOut(){
        Map map=TypeUtil.successMap();
        request.getSession().setAttribute("sysUser",null);
        return map;
    }
}
