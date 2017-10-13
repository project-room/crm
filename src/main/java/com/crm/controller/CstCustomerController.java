package com.crm.controller;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.entity.*;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/19.
 */
@Controller
public class CstCustomerController extends BaseController{

    @Autowired
    private  ICstCustomerService cstCustomerService;
    /**
     * 查看所有认领的公海客户
     * @return
     */
    @RequestMapping("selectGonghaiCstCustomer")
    public Map index(){
        Map map=TypeUtil.successMap();
        List<CstCustomer> customerList= null;
        try {
            customerList = cstCustomerService.selectAllCstCutomer();
            map.put("customerList",customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 认领公海客户
     * @return
     */
    @RequestMapping("cliamCstCustomer")
    public Map cliamCstCustomer(){
        Map map=TypeUtil.successMap();
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
        }
        return map;
    }

    /**
     * 批量认领公海客户
     * @return
     */
    @RequestMapping ("cliamCstCustomerByBatch")
    public Map cliamCstCustomerByBatch(){
        Map map =TypeUtil.successMap();

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
        }

        return map;
    }


    /**
     *通过分页bean获取认领公海客户信息
     * @return
     */
    @RequestMapping("getPage")
    public String getPage(Model model){
        Map map=TypeUtil.successMap();
        try {
            Page<CstCustomer> cstCustomerPage= cstCustomerService.getCstCustomerOnePageInfo(1,4);
            cstCustomerPage.getCurrentPage();
            cstCustomerPage.getList();
            cstCustomerPage.getPageSize();
            cstCustomerPage.getRecTotal();
            cstCustomerPage.getTotalPage();
//            map.put("cstCustomerPage",cstCustomerPage);
            model.addAttribute("cstCustomerPage",cstCustomerPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "page/customer";
    }

    /**
     * 根据id查看认领公海客户信息
     * @return
     */
    @RequestMapping("lookCstCustomerInfo")
    public Map lookCstCustomerInfo(){
        Map map= TypeUtil.successMap();
        try {
            CstCustomer cstCustomer=  cstCustomerService.lookCstCustomerInfo(1L);
            map.put("cstCustomer",cstCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 输入认领客户名称模糊搜索客户
     * @return
     */
    @RequestMapping("selectCstCustomerByName")
    public Map selectCstCustomerByName(){
        Map map=TypeUtil.successMap();
        try {
            List<CstCustomer> cstCustomers=  cstCustomerService.selectCstCustomerByName("广州");
            map.put("cstCustomers",cstCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据认领公海客户id删除公海客户
     * @return
     */
    @RequestMapping("deleteCstCustomerById")
    public Map deleteCstCustomerById(){
        Map map=TypeUtil.successMap();
        try {
            cstCustomerService.deleteCstCustomerById(27l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 批量删除认领公海客户
     * @return
     */
    @RequestMapping("deleteCstCustomerByBatch")
    public Map deleteCstCustomerByBatch(){
        Map map=TypeUtil.successMap();
        try {
            Long[] idArray={17L,18L,19L,20L,23L};
            for (int i=0;i<idArray.length;i++){
                cstCustomerService.deleteCstCustomerById(idArray[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 编辑认领公海客户信息
     * @return
     */
    @RequestMapping("editCstCustomerInfo")
    public Map editCstCustomerInfo(){
        Map map=TypeUtil.successMap();
        try {
            Long custId=24L;
            CstCustomer cstCustomer=new CstCustomer();
            cstCustomer.setCustCompany("南方公司");
            ChLinkman chLinkman=new ChLinkman();
            chLinkman.setLinkStatus(0);
            chLinkman.setCustId(custId);
            chLinkman.setLinkWechat("linxiren");
            chLinkman.setLinkName("李天下");
            CstLowCustomer cstLowCustomer=new CstLowCustomer();
//            cstLowCustomer.setCustCompany("下级代理客户名称");
//            cstLowCustomer.setHighCustId(3l);
//            cstLowCustomer.setCustId(3L);
            CstLabel cstLabel=new CstLabel();
            cstLabel.setLabelName("随和客户");
            cstCustomerService.editCstCustomerInfo(custId,1L,cstCustomer,cstLowCustomer,chLinkman,cstLabel);
            int labelId=cstLabel.getLabelId();
            map.put("labelId",labelId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("toIndex")
    public String toIndex(Model model){
        Map map=TypeUtil.successMap();
        model.addAttribute("bind","欢迎您的到来");
        return "page/index";
    }

    @RequestMapping("toShow")
    public String showInfo(SysUser sysUser,Model model){
        String username= sysUser.getUserName();
        String password= sysUser.getUserPassword();
        model.addAttribute("userName",username);
        model.addAttribute("userPassword",password);
        return "show";
    }



}
