package com.crm.controller;

import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.sys.service.ISysUserService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.converter.CstCustomerConverter;
import com.crm.dto.DataConditionDto;
import com.crm.entity.*;
import com.crm.enums.ChLinkmanStatusEnums;
import com.crm.enums.CstCustomerTypeEnums;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/19.
 */
@Controller
@RequestMapping("/cstCustomer")
public class CstCustomerController extends BaseController{

    @Autowired
    private  ICstCustomerService cstCustomerService;


    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index/index";
    }
    @RequestMapping("/toAddNewCustomer")
    public String toAddNewCustomer(){
        return "index/addNewCustomer";
    }

    @RequestMapping("/toCreateChance")
    public String toCreateChance(){
        return "index/createChance";
    }
    @RequestMapping("/toEditCustomer")
    public String toEditCustomer(){
        return "index/editCustomer";
    }
    @RequestMapping("/toSeas")
    public String toSeas(){
        return "index/seas";
    }
    @RequestMapping("/toRefferal")
    public String toRefferal(){return "index/refferal";}
    @RequestMapping("/toChance")
    public String toChance(){
        return "index/chance";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "index/login";
    }
    @RequestMapping("/toNewPsd")
    public String toNewPsd(){
        return "index/newPsd";
    }
    @RequestMapping("/toFindPsd")
    public String toFindPsd(){
        return "index/findPsd";
    }

    @RequestMapping("/toAddEmployee")
    public String toAddEmployee(){
        return "index/addEmployee";
    }
    @RequestMapping("/toAddEmployee_O")
    public String toAddEmployee_O(){
        return "index/addEmployee_O";
    }
    @RequestMapping("/toEditEmployee")
    public String toEditEmployee(){
        return "index/editEmployee";
    }
    @RequestMapping("/toEditEmployee_O")
    public String toEditEmployee_O(){
        return "index/editEmployee_O";
    }
    @RequestMapping("/toOrganize")
    public String toOrganize(){
        return "index/organize";
    }
    @RequestMapping("/toOrganizeNone")
    public String toOrganizeNone(){
        return "index/organizeNone";
    }
    @RequestMapping("/toSeasManager")
    public String toSeasManager(){
        return "index/seas-manager";
    }
    @RequestMapping("/toSetting")
    public String toSetting(){
        return "index/setting";
    }
    @RequestMapping("/toPersonMsg")
    public String toPersonMsg(){
        return "index/personMsg";
    }
    @RequestMapping("/toSettingSearch")
    public String toSettingSearch(){
        return "index/settingSearch";
    }



    /**
     * 新建公海客户
     * @return
     */
    @RequestMapping("/createCstCustomer")
    public String createCstCustomer(CstCustomer cstCustomer,ChLinkman chLinkman){
        Map map=result();
        try {
//            //判断是qq还是邮箱
//            if(RegexUtil.isNumeric(qqOrLinkEmail)){
//                chLinkman.setLinkQq(qqOrLinkEmail);
//            }else{
//                chLinkman.setLinkEmail(qqOrLinkEmail);
//            }
            Date date=new Date(System.currentTimeMillis());
            cstCustomer.setCustDate(date);
            cstCustomer.setCustType("2");
            cstCustomer.setCustClassify(2);
            Long custId=cstCustomerService.createCstCustomer(cstCustomer,chLinkman);

            //首页添加客户动态
            Long userId=(Long)session.getAttribute("userId");
            SysUser sysUser= cstCustomerService.selectUserById(userId);
            String userName=sysUser.getUserName();
            String roleName=(String)session.getAttribute("roleName");
            Long roleId=null;
            if(roleName.equals("管理员")){
                roleId=1L;
            }
            if(roleName.equals("销售经理")){
                roleId=2L;
            }
            if(roleName.equals("销售员")){
                roleId=3L;
            }
            int dyClassify=7;
            String dyContent="添加了客户";
            CstCustomer cstCustomerForCompany= cstCustomerService.lookCstCustomerInfo(custId);
            String custCompany= cstCustomerForCompany.getCustCompany();

            cstCustomerService.addCstCustomerSysDynamic(userId,userName,roleId,dyClassify,dyContent,date,custId,custCompany);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","新建客户失败");
        }

        return "redirect:" + "/cstCustomer/getPage/1/7";

    }

    /**
     * 筛选公海客户
     * @return
     */
    @RequestMapping("/selectCstCustomersByCondition/{custCompany}/{linkName}/{linkPhone}/{linkLandlinePhone}/{userName}/{linkEmail}/{year}/{minute}/{currentPageFor}/{pageSize}")
    public String selectCstCustomersByCondition(@PathVariable("custCompany") String custCompany,@PathVariable("linkName") String linkName,@PathVariable("linkPhone") String linkPhone,@PathVariable("linkLandlinePhone") String linkLandlinePhone,@PathVariable("userName") String userName,@PathVariable("linkEmail") String linkEmail,@PathVariable("year") String year,@PathVariable("minute") String minute,@PathVariable("currentPageFor") Integer currentPageFor,@PathVariable("pageSize") Integer pageSize,Model model){
        Map map=result();

        //用对象封装参数
        CstCustomer cstCustomer=new CstCustomer();
        ChLinkman chLinkman=new ChLinkman();
        cstCustomer.setCustCompany(custCompany);
        chLinkman.setLinkName(linkName);
        chLinkman.setLinkPhone(linkPhone);
        chLinkman.setLinkLandlinePhone(linkLandlinePhone);
        chLinkman.setLinkEmail(linkEmail);

        try {

            //固定参数
            model.addAttribute("year");
            model.addAttribute("minute");
            model.addAttribute("userName");
            String custCompanyPage=cstCustomer.getCustCompany();
            model.addAttribute("custCompany",custCompanyPage);
            String linkNamePage=chLinkman.getLinkName();
            model.addAttribute("linkName",linkNamePage);
            String linkPhonePage=chLinkman.getLinkPhone();
            model.addAttribute("linkPhone",linkPhonePage);
            String linkLandlinePhonePage=chLinkman.getLinkLandlinePhone();
            model.addAttribute("linkLandlinePhone",linkLandlinePhonePage);
            String linkEmailPage=chLinkman.getLinkEmail();
            model.addAttribute("linkEmail",linkEmailPage);

            //获取角色名
            String roleName=(String) session.getAttribute("roleName");
            //获取用户id
            Long userIdForPage=(Long)session.getAttribute("userId");
            //年月日
            String yearStr=year.replace("年","-").replace("月","-").replace("日"," ");
            //时分秒
            String[] arrTime=minute.split("-");
            String startTime=arrTime[0].trim();
            String endTime=arrTime[1].trim();

            //开始字符串时间
            String startTimeStr=yearStr+startTime;
            System.out.println("fjsf:"+startTimeStr);
            //结束字符串时间
            String endTimeStr=yearStr+endTime;
            //开始时间
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTimeDate=sdf.parse(startTimeStr);
            //结束时间
            Date endTimeDate=sdf.parse(endTimeStr);

            pageSize=7;
            Page<CstCustomer> returnCstCustomer= cstCustomerService.selectCstCustomerByCondition(userIdForPage,roleName,userName,startTimeDate,endTimeDate,cstCustomer,chLinkman,currentPageFor,pageSize,startTimeStr);
            //设置创建时间格式
            List<CstCustomer> cstCustomers= returnCstCustomer.getList();
            for (CstCustomer cstCustomerRevert:cstCustomers
                    ) {
                Date formation= cstCustomerRevert.getCustDate();
                String afterDate= new  SimpleDateFormat("yyyy-MM-dd hh：mm").format(formation).toString();
                cstCustomerRevert.setRevertDate(afterDate);
            }
            //组装分页数组
            List<Long> arrInteger=new ArrayList<Long>();
            Long totalPage=returnCstCustomer.getTotalPage();
            for(int i=1;i<=totalPage;i++){
                arrInteger.add(new Long(i));
            }
            model.addAttribute("arrInteger",arrInteger);
//            map.put("returnCstCustomer",returnCstCustomer);
            model.addAttribute("cstCustomerPage",returnCstCustomer);
            model.addAttribute("normal",1);

            //加载用户列表
            Long roleId = 3L;
            int userStatus=1;
            String districtA = "A区";
            String districtB="B区";
            String districtC = "C区";
            String districtD="D区";
            List<SysUser> sysUsersA = cstCustomerService .bySysUserList(roleId, districtA,userStatus);
            List<SysUser> sysUsersB = cstCustomerService.bySysUserList(roleId, districtB,userStatus);
            List<SysUser> sysUsersC = cstCustomerService.bySysUserList(roleId, districtC,userStatus);
            List<SysUser> sysUsersD = cstCustomerService.bySysUserList(roleId, districtD,userStatus);
            model.addAttribute("sysUsersA", sysUsersA);
            model.addAttribute("sysUsersB", sysUsersB);
            model.addAttribute("sysUsersC", sysUsersC);
            model.addAttribute("sysUsersD", sysUsersD);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","筛选客户失败");
        }

        return "index/seas";
    }

    /**
     * 查看所有认领的公海客户
     * @return
     */
    @RequestMapping("selectGonghaiCstCustomer")
    public Map index(){
        Map map=result();
        List<CstCustomer> customerList= null;
        try {
            customerList = cstCustomerService.selectAllCstCutomer();
            map.put("customerList",customerList);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","查看所有认领公海客户失败");
        }

        return map;
    }

    /**
     * 认领公海客户
     * @return
     */
    @RequestMapping("cliamCstCustomer")
    public Map cliamCstCustomer(){
        Map map=result();
        try {
            CstCustomer cstCustomer=new CstCustomer();
            cstCustomer.setCustEmail("324224@qq.com");
            cstCustomer.setCustCompany("平安旅游有限公司");
            cstCustomer.setCustAddress("湖南");
            cstCustomer.setCustIndustry("餐饮");
            cstCustomer.setCustPic("img/5.jpg");
            cstCustomer.setCustSales("城市");
            //在Session中拿负责人的id
            SysUser sysUser=new SysUser();
            sysUser.setUserId(3l);
            request.getSession().setAttribute("sysUser",sysUser);
            SysUser sysUser1=(SysUser) request.getSession().getAttribute("sysUser");
            Long userId= sysUser1.getUserId();
            cstCustomer.setUserId(userId);
            cstCustomer.setCustClassify(2);
            cstCustomer.setCustContent("餐饮");
            cstCustomer.setCustLifecycle("失效客户");
            cstCustomer.setCustWebsite("amu.cn.com");
            cstCustomer.setCustType("代理商");


            ChLinkman chLinkman=new ChLinkman();
            chLinkman.setLinkName("平安");
            chLinkman.setLinkPhone("13648373738");
            chLinkman.setLinkLandlinePhone("34234244");
            chLinkman.setLinkEmail("243242@qq.com");
            chLinkman.setLinkQq("3424343443");
            chLinkman.setLinkWechat("weixin");
            chLinkman.setLinkStatus(0);
//        chLinkman.setChId();
            chLinkman.setLinkDepartment("销售部");
            chLinkman.setLinkPosition("主管");

            cstCustomerService.cliamCstCustomer(cstCustomer,chLinkman);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","认领公海客户失败");

        }
        return map;
    }

    /**
     * 批量认领公海客户
     * @return
     */
    @RequestMapping ("cliamCstCustomerByBatch")
    public Map cliamCstCustomerByBatch(){
        Map map =result();

        try {
            CstCustomer cstCustomer=new CstCustomer();
            cstCustomer.setCustEmail("324224@qq.com");
            cstCustomer.setCustCompany("江西旅游有限公司");
            cstCustomer.setCustAddress("湖南");
            cstCustomer.setCustIndustry("餐饮");
            cstCustomer.setCustPic("img/5.jpg");
            cstCustomer.setCustSales("城市");
            //在Session中拿负责人的id
            SysUser sysUser=new SysUser();
            sysUser.setUserId(3l);
            request.getSession().setAttribute("sysUser",sysUser);
            SysUser sysUser1=(SysUser) request.getSession().getAttribute("sysUser");
            Long userId= sysUser1.getUserId();
            cstCustomer.setUserId(userId);
            cstCustomer.setCustClassify(2);
            cstCustomer.setCustContent("餐饮");
            cstCustomer.setCustLifecycle("失效客户");
            cstCustomer.setCustWebsite("amu.cn.com");
            cstCustomer.setCustType("代理商");

//
            CstCustomer cstCustomer1=new CstCustomer();
            cstCustomer1.setCustEmail("324224@qq.com");
            cstCustomer1.setCustCompany("云南旅游有限公司");
            cstCustomer1.setCustAddress("湖南");
            cstCustomer1.setCustIndustry("餐饮");
            cstCustomer1.setCustPic("img/5.jpg");
            cstCustomer1.setCustSales("城市");
            //在Session中拿负责人的id
            SysUser sysUser11=new SysUser();
            sysUser11.setUserId(3l);
            request.getSession().setAttribute("sysUser",sysUser);
            SysUser sysUser111=(SysUser) request.getSession().getAttribute("sysUser");
            Long userId1= sysUser111.getUserId();
            cstCustomer1.setUserId(userId1);
            cstCustomer1.setCustClassify(2);
            cstCustomer1.setCustContent("餐饮");
            cstCustomer1.setCustLifecycle("失效客户");
            cstCustomer1.setCustWebsite("amu.cn.com");
            cstCustomer1.setCustType("代理商");

//
            ChLinkman chLinkman=new ChLinkman();
            chLinkman.setLinkName("苏东垤");
            chLinkman.setLinkPhone("13648373738");
            chLinkman.setLinkLandlinePhone("34234244");
            chLinkman.setLinkEmail("243242@qq.com");
            chLinkman.setLinkQq("3424343443");
            chLinkman.setLinkWechat("weixin");
            chLinkman.setLinkStatus(0);
//        chLinkman.setChId();
            chLinkman.setLinkDepartment("销售部");
            chLinkman.setLinkPosition("主管");
//
            ChLinkman chLinkman1=new ChLinkman();
            chLinkman1.setLinkName("王协");
            chLinkman1.setLinkPhone("13648373738");
            chLinkman1.setLinkLandlinePhone("34234244");
            chLinkman1.setLinkEmail("243242@qq.com");
            chLinkman1.setLinkQq("3424343443");
            chLinkman1.setLinkWechat("weixin");
            chLinkman1.setLinkStatus(0);
//        chLinkman.setChId();
            chLinkman1.setLinkDepartment("销售部");
            chLinkman1.setLinkPosition("主管");


            List<CstCustomer> cstCustomers=new ArrayList<CstCustomer>();
            List<ChLinkman> chLinkmens=new ArrayList<ChLinkman>();
            cstCustomers.add(cstCustomer);
            cstCustomers.add(cstCustomer1);
            chLinkmens.add(chLinkman);
            chLinkmens.add(chLinkman1);
            for (int i=0;i<cstCustomers.size();i++){
                cstCustomerService.cliamCstCustomer(cstCustomers.get(i),chLinkmens.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","批量认领公海客户失败");
        }

        return map;
    }


    /**
     *通过分页bean获取认领公海客户信息
     * @return
     */
    @RequestMapping("/getPage/{currentPage}/{pageSize}")
    public String getPage(@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize, Model model){
        Map map=result();
        Set<String> date=null;
        Page<CstCustomer> cstCustomerPage=null;
        try {
            //获取角色名
            String roleName=(String) session.getAttribute("roleName");
            System.out.println(roleName+"角色名");
            //获取用户id
            Long userIdForPage=(Long)session.getAttribute("userId");
            cstCustomerPage= cstCustomerService.getCstCustomerOnePageInfo(userIdForPage,roleName,currentPage,pageSize);

            //设置创建时间格式
            List<CstCustomer> cstCustomers= cstCustomerPage.getList();

            for (CstCustomer cstCustomer:cstCustomers
                    ) {
                Date formation= cstCustomer.getCustDate();
                String afterDate= new  SimpleDateFormat("yyyy-MM-dd hh：mm").format(formation).toString();
                cstCustomer.setRevertDate(afterDate);
            }
            //组装分页数组
            List<Long> arrInteger=new ArrayList<Long>();
            Long totalPage=cstCustomerPage.getTotalPage();
            for(int i=1;i<=totalPage;i++){
                arrInteger.add(new Long(i));
            }
            model.addAttribute("arrInteger",arrInteger);
            model.addAttribute("cstCustomerPage",cstCustomerPage);
            //标记为公海普通分页
            model.addAttribute("normal",0);

            //加载用户列表
            Long roleId = 3L;
            int userStatus=1;
            String districtA = "A区";
            String districtB="B区";
            String districtC = "C区";
            String districtD="D区";
            List<SysUser> sysUsersA = cstCustomerService .bySysUserList(roleId, districtA,userStatus);
            List<SysUser> sysUsersB = cstCustomerService.bySysUserList(roleId, districtB,userStatus);
            List<SysUser> sysUsersC = cstCustomerService.bySysUserList(roleId, districtC,userStatus);
            List<SysUser> sysUsersD = cstCustomerService.bySysUserList(roleId, districtD,userStatus);
            model.addAttribute("sysUsersA", sysUsersA);
            model.addAttribute("sysUsersB", sysUsersB);
            model.addAttribute("sysUsersC", sysUsersC);
            model.addAttribute("sysUsersD", sysUsersD);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","获取分页公海客户失败");
        }
        return "index/seas";
    }

    /**
     * 根据id查看认领公海客户信息
     * @return
     */
    @RequestMapping("/lookCstCustomerInfo/{custId}")
    public String lookCstCustomerInfo(@PathVariable("custId") String custId,Model model){
        try {
            Long cstCustomerId=null;
            if(custId.contains("-")){
                //去掉首字符"-"
                String revertCustIdArr=custId.substring(1);
                String[] idArr= revertCustIdArr.split("-");
                cstCustomerId=new Long(idArr[0]);

            }else{
                cstCustomerId=new Long(custId);
            }
            CstCustomer cstCustomer=  cstCustomerService.lookCstCustomerInfo(cstCustomerId);
            if(cstCustomer!=null){
                //转换创建日期格式
                CstCustomerConverter.dateConvertor(cstCustomer);
                model.addAttribute("cstCustomer",cstCustomer);
                return "index/editCustomer";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:"+"/getTaskListByUserId";
    }

    /**
     * 输入认领客户名称模糊搜索客户
     * @return
     */
    @RequestMapping("/selectCstCustomerByName/{custCompany}/{currentPage}/{pageSize}")
    public String  selectCstCustomerByName(@PathVariable("custCompany") String custCompany,@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize,Model model){
        Map map=result();
        //获取角色名
        String roleName=(String) session.getAttribute("roleName");
        //获取用户id
        Long userIdForPage=(Long)session.getAttribute("userId");
        Long count=cstCustomerService.selectCountByCstCustomerName(userIdForPage,roleName,custCompany);
        try {
            List<CstCustomer> cstCustomers=  cstCustomerService.selectCstCustomerByName(userIdForPage,roleName,custCompany,currentPage,pageSize);
            for (CstCustomer cstCustomer:cstCustomers
                    ) {
                //通过用户id获取用户名
                Long userId=cstCustomer.getUserId();
                SysUser sysUser= cstCustomerService.selectUserById(userId);
                String userName=sysUser.getUserName();
                cstCustomer.setRevertUserNameFromId(userName);
                //转换时间格式
                CstCustomerConverter.dateConvertor(cstCustomer);
            }
            Page<CstCustomer> pageCstCustomerByName= new Page<CstCustomer>(currentPage,pageSize,cstCustomers,count);
            map.put("cstCustomerPage",pageCstCustomerByName);
            model.addAttribute("cstCustomerPage",pageCstCustomerByName);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","按客户名称搜索失败");
        }
        return "index/seas";
    }

    /**
     * 根据认领公海客户id删除公海客户
     * @return
     */
    @RequestMapping("deleteCstCustomerById/{cstCustomerId}")
    public String deleteCstCustomerById(@PathVariable("cstCustomerId") Long cstCustomerId){
        Map map=result();
        try {
            cstCustomerService.deleteCstCustomerById(cstCustomerId);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","删除公海客户失败");
        }
        return "redirect:" + "/cstCustomer/getPage/1/7";
    }

    /**
     * 批量删除认领公海客户
     * @return
     */
    @RequestMapping("deleteCstCustomerByBatch")
    public Map deleteCstCustomerByBatch(@PathVariable("idArray") Long[] idArray){
        Map map=result();
        try {
            for (int i=0;i<idArray.length;i++){
                cstCustomerService.deleteCstCustomerById(idArray[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","批量删除公海客户失败");
        }
        return map;
    }

    /**
     * 编辑认领公海客户信息
     * @return
     */
    @RequestMapping("/editCstCustomerInfo")
//    String custId, String userId, CstCustomer cstCustomer, CstLowCustomer cstLowCustomer, ChLinkman chLinkman, CstLabel cstLabel
    public Map editCstCustomerInfo(){
        Map map=result();
        try {
            //负责人id
            Long userId=1L;
            //客户id
            Long custId=1L;
            //客户属性
            CstCustomer cstCustomer=new CstCustomer();
            cstCustomer.setCustEmail("88888888@qq.com");
            cstCustomer.setCustCompany("腾达公司");
            cstCustomer.setCustAddress("广西南宁");
            cstCustomer.setCustIndustry("软件行业");
            cstCustomer.setCustPic("img/10.jpg");
            cstCustomer.setCustSales("网站");
            cstCustomer.setUserId(userId);
            cstCustomer.setCustClassify(CstCustomerTypeEnums.GONGHAI_CUSTOMER_TYPE.getCode());
            cstCustomer.setCustContent("客户内容");
            cstCustomer.setCustLifecycle("成交客户");
            cstCustomer.setCustWebsite("com.zena.cn");
            cstCustomer.setCustType("代理商");
            cstCustomer.setCustDate(new Date (System.currentTimeMillis()));

            //主联系人的属性
            ChLinkman chLinkman=new ChLinkman();
            chLinkman.setLinkName("王斌");
            chLinkman.setLinkPhone("13417027948");
            chLinkman.setLinkLandlinePhone("887766");
            chLinkman.setLinkEmail("23424@163.com");
            chLinkman.setLinkQq("2993460938");
            chLinkman.setLinkWechat("linmuxin");
            chLinkman.setLinkStatus(ChLinkmanStatusEnums.MASTER_CHLINKMAN.getCode());
            chLinkman.setChId(1L);
            chLinkman.setLinkDepartment("产品部");
            chLinkman.setLinkPosition("经理");
            chLinkman.setCustId(custId);

            //下级客户属性
            CstLowCustomer cstLowCustomer=new CstLowCustomer();
            cstLowCustomer.setHighId(custId);
            cstLowCustomer.setCustLowCompany("下级公司名称");
            cstLowCustomer.setCustLowId(2L);

            //下级客户属性
            CstLowCustomer cstLowCustomer2=new CstLowCustomer();
            cstLowCustomer2.setHighId(custId);
            cstLowCustomer2.setCustLowCompany("下级公司名称2");
            cstLowCustomer2.setCustLowId(3L);

            //下级客户属性
            CstLowCustomer cstLowCustomer3=new CstLowCustomer();
            cstLowCustomer3.setHighId(custId);
            cstLowCustomer3.setCustLowCompany("下级公司名称3");
            cstLowCustomer3.setCustLowId(4L);

            //下级客户组
            List<CstLowCustomer> cstLowCustomers=new ArrayList<CstLowCustomer>();
            cstLowCustomers.add(cstLowCustomer);
            cstLowCustomers.add(cstLowCustomer2);
            cstLowCustomers.add(cstLowCustomer3);

            //标签表属性
            CstLabel cstLabel=new CstLabel();
            cstLabel.setLabelName("新标签");
            cstLabel.setUserId(2L);

            //标签表属性
            CstLabel cstLabel2=new CstLabel();
            cstLabel2.setLabelName("新标签1");
            cstLabel2.setUserId(2L);

            //标签表属性
            CstLabel cstLabel3=new CstLabel();
            cstLabel3.setLabelName("新标签2");
            cstLabel3.setUserId(2L);

            //标签组
            List<CstLabel> cstLabels=new ArrayList<CstLabel>();
            cstLabels.add(cstLabel);
            cstLabels.add(cstLabel2);
            cstLabels.add(cstLabel3);



            cstCustomerService.editCstCustomerInfo(custId,userId,cstCustomer,cstLowCustomers,chLinkman,cstLabels);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","编辑失败");
        }
        return map;
    }

    //根据id编辑公海客户
    @RequestMapping("editCustomerById")
    public String editCustomerById(CstCustomer cstCustomer,ChLinkman chLinkman,String custDateStr){
        Map map=result();
        try {
            cstCustomer.setCustType(CstCustomerTypeEnums.GONGHAI_CUSTOMER_TYPE.getCode().toString());
            chLinkman.setLinkStatus(ChLinkmanStatusEnums.MASTER_CHLINKMAN.getCode());
            chLinkman.setCustId(cstCustomer.getCustId());

            //把字符串时间转换为Date格式
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm " );
            String formatCustDateStr=custDateStr.replace("：",":");
            Date date = sdf.parse(" "+formatCustDateStr+" ");
            cstCustomer.setCustDate(date);
            cstCustomerService.editCustomerById(cstCustomer,chLinkman);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:" + "/cstCustomer/getPage/1/7";
    }

    /**
     * 分配公海客户
     * @param request
     * @param response
     */
    @RequestMapping("/distributeCstCustomer")
    public void distributeCstCustomer(HttpServletRequest request,HttpServletResponse response){

        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out= response.getWriter();
            String userId= request.getParameter("userId");
            Long userIdLong=new Long(userId);
            String custIdStr=request.getParameter("custIdStr");

            Long cstCustomerId=null;
            //去掉首字符"-"
            String revertCustIdArr=custIdStr.substring(1);
            String[] idArr= revertCustIdArr.split("-");

            for (int i=0;i<idArr.length;i++){
                Long custIdLong= new Long(idArr[i]);
                //判断客户是否已经被分配
                Integer flagDistri=cstCustomerService.lookCstCustomerInfo(custIdLong).getFlagDistri();
                if(flagDistri==null){
                    //分配赋值为0
                    flagDistri=0;
                    //更张客户的用户id
                    cstCustomerService.updateCstCustomerSysUserProperties(custIdLong,userIdLong,flagDistri);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id批量删除客户
     * @param custIdArr
     */
    @RequestMapping("/deleteAllCustomer/{custIdArr}")
    public String deleteAllCustomer(@PathVariable("custIdArr") String custIdArr){
//        int index= custIdArr.indexOf("-");
        //去掉首字符"-"
        String revertCustIdArr=custIdArr.substring(1);
        String[] idArr= revertCustIdArr.split("-");
        for (int i=0;i<idArr.length;i++){
            Long custId=new Long(idArr[i]);
            System.out.println("custId"+custId);
            cstCustomerService.deleteCstCustomerById(custId);
        }
        return "redirect:" + "/cstCustomer/getPage/1/7";
    }
}
