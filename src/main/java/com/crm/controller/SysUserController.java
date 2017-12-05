
package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.entity.SysRole;
import com.crm.entity.SysUser;
import com.crm.utils.AliSms;
import com.crm.utils.SixCaptchaUtil;
import com.crm.utils.TypeUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private ISysUserService sysUserService;
    @RequestMapping("selectSysUserById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        SysUser sysUser=sysUserMappers.findById(1l);
        map.put("sysUser",sysUser);
        return map;
    }

    //用户登录
    @RequestMapping("/userLogin")
    public void login(HttpServletRequest request ,HttpServletResponse response){
        try {
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
            SysUser sysUser=sysUserService.login(username,password);
            //如果用户为停用状态不能登录
            if(sysUser!=null&&sysUser.getUserStatus()!=0){
               /* redisTemplate.opsForValue().set("userName",username,7200, TimeUnit.SECONDS);*/
               //获取用户的角色
                Long roleId=sysUser.getRoleId();
                SysRole sysRole=sysUserService.selectRoleById(roleId);
                session.setAttribute("roleName",sysRole.getRoleName());
                session.setAttribute("userId",sysUser.getUserId());
                //用户状态如何为停用状态不能登录成功
                out.print("1");

            }else{
                out.print("0");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            int state = sysUserService.register(sysUser); //state是判断是否添加成功。 以后或许有用
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
            int state = sysUserService.deleteById(userId);

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
            int state =sysUserService.updateSysUserById(sysUser);
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
            Long userId= sysUserService.selectUserIdByUserName(userName);
           PrintWriter out= response.getWriter();
            out.print(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


/**
     * 获取发送短信验证码
     * @param phone
     * @return
     */

    @RequestMapping("/sendSmsCaptcha/{phone}")
//    13307278157
    public String sendSmsCaptche(@PathVariable("phone") String phone,Model model){
       String captCha= SixCaptchaUtil.getRandNum(6);
       //发短手机信息验证码
       AliSms.sendSmsByPhone(phone,captCha);
       redisTemplate.opsForValue().set("captCha",captCha,120,TimeUnit.SECONDS);
       redisTemplate.opsForValue().set("phone",phone,120,TimeUnit.SECONDS);
        System.out.println("captCha:"+captCha);
        model.addAttribute("phone",phone);
       return "index/findPsd";
    }
//
/**
     * 根据用户号码和验证码来提交
     * @param phone
     * @param captCha
     * @return
     */

    @RequestMapping("/findByPhoneAndCaptCha/{phone}/{captCha}")
    public String findByPhoneAndCaptCha(@PathVariable("phone") String phone,@PathVariable("captCha") String captCha){
        String captChaRedis= null;
        String phoneChaRedis= null;
        try {
            captChaRedis = redisTemplate.opsForValue().get("captCha").toString();
            phoneChaRedis = redisTemplate.opsForValue().get("phone").toString();
            if(captChaRedis.equals(captCha.trim())&&phoneChaRedis.equals(phone.trim())){
                session.setAttribute("sysUserPhone",phone);
                return "index/newPsd";
            }else{
                return "index/findPsd";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "index/findPsd";
        }

    }

    /**
     * 创建新的密码
     * @param newPassword
     */


@RequestMapping("/createNewPassword/{newPassword}")
    public String createNewPassword(@PathVariable("newPassword") String newPassword){
      String sysUserPhone= session.getAttribute("sysUserPhone").toString();
       //根据用户号码查出用户
      SysUser sysUser= sysUserService.selectSysUserByUserPhone(sysUserPhone);
      //改变用户的密码
      sysUser.setUserPassword(newPassword);
      //修改用户密码
      sysUserService.updateSysUserById(sysUser);
      session.setAttribute("sysUserPhone",null);
      return "index/login";
    }

    /**
     * 页面获取session
     * @param response
     */
    @RequestMapping("/getSession")
    public void toGetSession(HttpServletRequest request,HttpServletResponse response){
        try {
            //设置编码为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out= response.getWriter();
           String roleName= session.getAttribute("roleName").toString();
           //判读是否为空
            out.print(roleName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取分页用户列表
     */
    @RequestMapping("/getSysUserList/{currentPage}/{pageSize}")
    public String getSysUserList(Model model,@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize){
        Map map=result();
        try {
            Page<SysUser> sysUserPage= sysUserService.getSysUserPage(currentPage,pageSize);
            //组装分页数组
            List<Long> arrInteger=new ArrayList<Long>();
            Long totalPage=sysUserPage.getTotalPage();
            for(int i=1;i<=totalPage;i++){
                arrInteger.add(new Long(i));
            }
            model.addAttribute("arrInteger",arrInteger);
            model.addAttribute("sysUserPage",sysUserPage);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "index/setting";
    }

    @RequestMapping("/addSysUser")
    public void addSysUser(SysUser sysUser,SysRole sysRole){
        //1-正常用户
        sysUser.setUserStatus(1);
        sysUserService.addSysUserBySysUserAndSysRole(sysUser,sysRole);
    }

    /**
     * 根据用户名或账号搜索分页用户
     * @param userNameOrAccount
     * @param currentPage
     * @param pageSize
     */
    @RequestMapping("/searchUserNameOrAccount/{userNameOrAccount}/{currentPage}/{pageSize}")
    public String searchUserNameAndAccount(@PathVariable("userNameOrAccount") String userNameOrAccount,@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize,Model model){
      Page<SysUser> sysUserPage=sysUserService.selectSysUserPageByUserNameAndAccount(userNameOrAccount,currentPage,pageSize);
        //组装分页数组
        List<Long> arrInteger=new ArrayList<Long>();
        Long totalPage=sysUserPage.getTotalPage();
        for(int i=1;i<=totalPage;i++){
            arrInteger.add(new Long(i));
        }
        //判断查询结果是否为空
        if(sysUserPage.getRecTotal()==0){
            //查询无果
            model.addAttribute("changeEmpty",0);
        }else{
            //查询不为空
            model.addAttribute("changeEmpty",1);
        }
        model.addAttribute("arrInteger",arrInteger);
        model.addAttribute("sysUserPage",sysUserPage);
        //固定参数
        model.addAttribute("userNameOrAccount",userNameOrAccount);
      return "index/settingSearch";
    }

    /**
     * 根据用户id获取用户信息
     * @param userIdStr
     */
    @RequestMapping("/getSysUserInfoById/{userIdStr}")
    public String getSysUserInfoById(@PathVariable("userIdStr") String userIdStr, Model model){

        Long userId=null;
        if(userIdStr.contains("-")){
//            int index= custId.indexOf("-");
            //去掉首字符"-"
            String revertSysUserIdArr=userIdStr.substring(1);
            String[] idArr= revertSysUserIdArr.split("-");
            userId=new Long(idArr[0]);

        }else{
            userId=new Long(userIdStr);
        }

        SysUser sysUser= sysUserService.selectSysUserInfoById(userId);
        if(sysUser!=null){
            model.addAttribute("sysUser",sysUser);
        }
        return "index/editEmployee";
    }

    /**
     * 登出功能
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(){
        session.setAttribute("roleName",null);
        session.setAttribute("userId",null);
        return "index/login";
    }

    /**
     * 编辑用户
     * @param sysUser
     */
    @RequestMapping("/editSysUserInfo")
    public void editSysUserInfo(SysUser sysUser){
       sysUserService.updateSysUserById(sysUser);
    }

    //加载用户名
    @RequestMapping("/loadUserName")
    public void loadUserName(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
            Long userId=(Long) session.getAttribute("userId");
            SysUser sysUser=sysUserService.selectSysUserInfoById(userId);
            //判断是否为空
            String userName=sysUser.getUserName();
            out.print(userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loadUserId")
    public void loadUserId(HttpServletRequest request,HttpServletResponse response){
        try {
            PrintWriter out=response.getWriter();
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            Long userId=(Long) session.getAttribute("userId");
            out.print(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户停用
     * @param userIdArr
     */
    @RequestMapping("/stopSysUserStatus/{userIdArr}")
    public String stopSysUserStatus(@PathVariable("userIdArr") String userIdArr){
        //去掉首字符"-"
        String revertCustIdArr=userIdArr.substring(1);
        String[] idArr= revertCustIdArr.split("-");
        for (int i=0;i<idArr.length;i++){
        Long userId=new Long(idArr[i]);
        SysUser sysUser=sysUserService.selectSysUserInfoById(userId);
         sysUser.setUserStatus(0);
         sysUserService.updateSysUserById(sysUser);
        }
        return "redirect:"+"/sysUser/getSysUserList/1/10";
    }

    /**
     * 根据账号查询密码
     * @param request
     * @param response
     */
    @RequestMapping("/getSysUserByUserName")
    public void getSysUserByUserName(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out= response.getWriter();
            String userName= request.getParameter("userName");
            SysUser sysUser= sysUserService.selectSysUserByAccounts(userName);
            if(sysUser!=null){
                JSONObject sysUserJson=JSONObject.fromObject(sysUser);
                out.print(sysUserJson);
            }else{
                //用户不存在
                out.print("0");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载销售经理列表
     * @return
     */
    @RequestMapping("/loadSalesManager")
    public String loadSalesManager(Model model){
        Long roleId=2L;
        List<SysUser> sysUsers= sysUserService.loadSalesManager(roleId);
        //加载用户列表
        Long salesRoleId = 3L;
        int userStatus=1;
        String districtA = "A区";
        String districtB="B区";
        String districtC = "C区";
        String districtD="D区";
        List<SysUser> sysUsersA = sysUserService .bySysUserList(salesRoleId, districtA,userStatus);
        List<SysUser> sysUsersB = sysUserService.bySysUserList(salesRoleId, districtB,userStatus);
        List<SysUser> sysUsersC = sysUserService.bySysUserList(salesRoleId, districtC,userStatus);
        List<SysUser> sysUsersD = sysUserService.bySysUserList(salesRoleId, districtD,userStatus);
        model.addAttribute("sysUsers",sysUsers);
        model.addAttribute("sysUsersA",sysUsersA);
        model.addAttribute("sysUsersB",sysUsersB);
        model.addAttribute("sysUsersC",sysUsersC);
        model.addAttribute("sysUsersD",sysUsersD);
        return "index/organize";
    }

    /**
     * 查看个人资料信息
     */
    @RequestMapping("/lookPersonInfo")
    public String lookPersonInfo(Model model){
        Long userId=(Long)session.getAttribute("userId");
        SysUser sysUser= sysUserService.selectSysUserInfoById(userId);
        model.addAttribute("sysUser",sysUser);
        return "index/personMsg";
    }

    /**
     * 编辑个人资料信息
     */
    @RequestMapping("/eiditPersonData")
    public String eiditPersonData(SysUser sysUser,Model model){
        Long userId=(Long)session.getAttribute("userId");
        sysUser.setUserId(userId);
        sysUserService.updatePersonDataById(sysUser);
        SysUser sysUserReturn=sysUserService.selectSysUserInfoById(userId);
        model.addAttribute("sysUser",sysUserReturn);
        return "index/personMsg";

    }
}
