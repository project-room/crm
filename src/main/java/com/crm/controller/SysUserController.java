package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.entity.SysUser;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/9/14.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserMapper sysUserMappers;
    @Autowired
    private StringRedisTemplate redisTemplate;

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
    @RequestMapping("/userLogin")
    public String login(String username,String password ,HttpServletResponse response){
         Map map= result();
         SysUser sysUser=iSysUserService.login(username,password);
         if(sysUser!=null){
             redisTemplate.opsForValue().set("userName",username,7200, TimeUnit.SECONDS);
             return "index/index";
         }
        return "index/login";
    }
    //记住登录
    @RequestMapping("/remenberLogin")
    public void remenberLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Map map=result();
       PrintWriter out= response.getWriter();
       String userName= request.getParameter("userName");
       String result= redisTemplate.opsForValue().get(userName);
       if(result!=null){
           out.print(true);
       }else{
           out.print(false);
       }

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

    //根据用户名获取用户id
    @RequestMapping("/userNameRevertUserId")
    public void userNameRevertUserId(HttpServletRequest request, HttpServletResponse response){
        String userName=request.getParameter("userName");
        try {
            Long userId= iSysUserService.selectUserIdByUserName(userName);
           PrintWriter out= response.getWriter();
            out.print(userId);
        } catch (Exception e) {e.printStackTrace();

        }
    }
}
