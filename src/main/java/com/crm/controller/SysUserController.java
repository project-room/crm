package com.crm.controller;

import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.SysDynamic;
import com.crm.entity.SysUser;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private ISysUserService iSysUserService;
    @RequestMapping("selectSysUserById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        SysUser sysUser=sysUserMappers.findById(1l);
        map.put("sysUser",sysUser);
        return map;
    }

    //用户登陆
    @RequestMapping("userLogin")
    public Map login(String username,String password){
        Map map= result();
        try {
            System.out.println("username:"+username +"    password:"+password);
            map = TypeUtil.successMap();
            SysUser sysUser=iSysUserService.login(username,password);
            map.put("sysUser",sysUser);
        } catch (Exception e) {
            map.put("code","-1");
            map.put("msg","登陆失败");
            e.printStackTrace();

        }
        return map;
    }

    //注册  形式有待商榷
    @RequestMapping("userRegister")
    public Map register(SysUser sysUser){
        Map map = result();
        try {
            int state = iSysUserService.register(sysUser); //state是判断是否添加成功。 以后或许有用
            map= TypeUtil.successMap();
            map.put("sysUser",sysUser);
        } catch (Exception e) {
            map.put("code","-1");
            map.put("msg","注册失败");
            e.printStackTrace();

        }

        return map;
    }

    //删除用户
    @RequestMapping("userDelete")
    public Map delete(Long userId){
        //到时候要么前端判断用户状态，要么在service判断状态，当状态为0时就不进行操作
        Map map = result();
        try{
            int state = iSysUserService.deleteById(userId);

//            if(state == 0){//删除失败
//            }else{//删除成功
                map= TypeUtil.successMap();
//            }

        } catch (Exception e) {
            map.put("code","-1");
            map.put("msg","删除失败");
            e.printStackTrace();

        }
        return map;
    }

    //修改用户
    @RequestMapping("userUpdate")
    public Map update(SysUser sysUser){
        Map map = result();
        try{
            int state =iSysUserService.updateSysUserById(sysUser);
            map= TypeUtil.successMap();
        } catch (Exception e) {
            map.put("code","-1");
            map.put("msg","修改失败");
            e.printStackTrace();

        }

        return map;
    }




}
