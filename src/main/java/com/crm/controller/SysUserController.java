package com.crm.controller;

import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.SysDynamic;
import com.crm.entity.SysUser;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class SysUserController extends BaseController {
    @Autowired
    private SysUserMapper sysUserMappers;
    @RequestMapping("selectSysUserById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        SysUser sysUser=sysUserMappers.findById(1l);
        map.put("sysUser",sysUser);
        return map;
    }


}
