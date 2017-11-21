package com.crm.controller;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.customer.service.ICstLowCustService;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.biz.customer.service.ICstScheduleService;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.entity.*;
import com.crm.utils.TypeUtil;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.jdbc.Null;
import org.codehaus.groovy.runtime.dgmimpl.arrays.LongArrayGetAtMetaMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 * ZHB
 */
@Controller
/*@RestController*/
@RequestMapping("/cstChance")
public class CstChanceController extends BaseController {

    @Autowired
    private ICstChanceService iCstChance;

    @Autowired
    private IUserTaskService iUserTaskService;

    @Autowired
    private ICstRecordService iCstRecordService;

    @Autowired
    private ICstScheduleService iCstScheduleService;


    @RequestMapping("/to")
    public String to() {

        System.out.println("到了吗");

        return "index/refferal";
    }

    //查询我的机会方法
//    Long userId ,@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize
    @RequestMapping("/getCstChance/{currentPage}/{pageSize}")
    public String /*Map*/ getCstChance(Model model, String custCompany,@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
        // 测试数据
        try {
             Long userIdLong=(Long) session.getAttribute("userId");
            Page<CstChance> cstChancePage = iCstChance.getCstChance(userIdLong,custCompany,currentPage, pageSize);
            if (cstChancePage.getPageSize() != 0) {
                List<Long> arrList = new ArrayList<>();
                Long totalPage = cstChancePage.getTotalPage();
                System.out.println(totalPage);
                for (int i = 1; i <= totalPage; i++) {
                    System.out.println(i);
                    arrList.add(new Long(i));
                }
               /* map.put("cstChancePage",cstChancePage);*/
                model.addAttribute("arrList", arrList);
                model.addAttribute("cstChancePage", cstChancePage);
            } else {
                map.put("-1", "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* return map;*/
        return "index/chance";
    }

    //机会添加方法
    @RequestMapping("/addCstChance")
    public String addCstChance(CstChance cstChance, CstCustomer cstCustomer, ChLinkman chLinkman, CstLowCustomer cstLowCustomer, Long linkIdTo, String linkDepartmentTo, String linkPositionTo) {
        Map map = result();
        Date date = new Date();
        date.getTime();
        cstChance.setChDate(date);
        try {
            boolean mak = iCstChance.addCstChance(cstChance, cstCustomer, chLinkman, cstLowCustomer, linkIdTo, linkDepartmentTo, linkPositionTo);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + "/cstChance/getCstChance/"+ 1 + "/" + 10;
    }

    //按机会id查询机会的详细信息
//    Long chId
    @RequestMapping("/getCstChanceId/{chId}")
    public  String /*Map*/ getCstChanceId(Model model,@PathVariable("chId") Long chId) {
        Map map = result();
        System.out.println("机会详情");
        //测试数据
        try {
             List<CstChance> cstChanceList = iCstChance.getCstChanceId(chId);
             List<CstRecord> RecordList = iCstRecordService.getCstRecord(chId);
             List<UserTask> userTasksList= iUserTaskService.getUserTask(chId);
            if (/*cstChanceList != null && */RecordList!=null) {
                /* map.put("RecordList",RecordList);*/
                model.addAttribute("cstChanceList", cstChanceList);
                model.addAttribute("RecordList", RecordList);
                model.addAttribute("userTasksList",userTasksList);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*return map;*/
        return "index/changeDetail";
    }

    //删除方法
    @RequestMapping("/deleteCstChance/{id}/{currentPage}/{pageSize}")
    public String deleteCstChance(@PathVariable("id") Long id, @PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
        try {
            boolean mak = iCstChance.deleteCstChance(id);
            iUserTaskService.deleteUserTaskChId(id);
            iCstRecordService.deleteCstRecordChId(id);
            iCstScheduleService.deleteCstSchedule(id);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + "/cstChance/getCstChance/" + currentPage + "/" + pageSize;
    }

    //修改方法
    @RequestMapping("/updateCstChance")
    public String updateCstChance(long chId, CstChance cstChance, CstCustomer customer, ChLinkman linkman) {
        Map map = result();
        try {
            boolean mak = iCstChance.updateCstChance(cstChance, customer, linkman);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + "/cstChance/getCstChanceId/" + chId;
    }

    //查询有多少条机会信息
//    Long userId
    @RequestMapping("/getCstChanceCount")
    public Map getCstChanceCount() {
        Map map = result();
        //测试数据
        Long userId = (long) 1;

        try {
            int count = iCstChance.getCstChanceCount(userId);
            map.put("count", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //根据条件查询
//    CstChance cstChance, @PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize
    @RequestMapping("/getCstChanceTo/{currentPage}/{pageSize}")
    public String getCstChanceTo(Model model, CstChance cstChance, CstCustomer cstCustomer, ChLinkman chLinkman, @PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
        System.out.println("走没走");
        cstChance.setChCustomer(cstCustomer);
        System.out.println(chLinkman.getLinkPhone());
        /*System.out.println(cstChance.getChCustomer().getCustCompany());*/
        //测试数据
/*
   CstChance cstChance = new CstChance();
        cstChance.setUserId((long) 1);
        int currentPage = 1;
        int pageSize = 2;
*/
        try {
            Page<CstChance> cstChancePage = iCstChance.getCstChanceTo(cstChance, chLinkman, currentPage, pageSize);
            System.out.println("走没走111111111");
            if (cstChancePage != null) {
               /* map.put("cstChancePage", cstChancePage);*/
                model.addAttribute("cstChancePage", cstChancePage);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index/chance";
    }

    //通过建立转交的机会
    @RequestMapping("/updateChance/{chId}/{userToId}")
    public String /*Map*/ updateChance(@PathVariable("chId") Long chId,@PathVariable("userToId") Long userToId) {
        Map map = result();
        CstChance cst=new CstChance();
        cst.setChId(chId);
        cst.setUserToId(userToId);
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            boolean mak = iCstChance.updateChance(cst);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "修改失败");
            }else {
                map.put("mak","修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*return map;*/
        return "redirect:"+"/cstChance/getCstChanceUserId/1/10";
    }

      //不通过转交的机会
      @RequestMapping("/updateChanceTo/{chId}")
       public String updateChanceTo(@PathVariable("chId") Long chId){
          Map map = result();
          try{
             /* request.setCharacterEncoding("UTF-8");
              response.setCharacterEncoding("UTF-8");*/
              boolean mak=iCstChance.updateChanceTo(chId);
               if (mak==false){
                   map.put("code", "-1");
                   map.put("msg", "修改失败");
               }else {
                   map.put("mak","修改成功");
               }

          } catch (Exception e){
              e.printStackTrace();
          }
        return "redirect:"+"/cstChance/getCstChanceUserId/1/10";
       }
/*    //按阶段来转交客户
    @RequestMapping("/updateCst")
    public Map updateCst(CstChance cstChance) {
        Map map = result();
//        CstChance cstChance = new CstChance();
//        cstChance.setChStage("签订合同");
//        cstChance.setUserId((long) 3);
//        cstChance.setUserName("张飞");
//        cstChance.setCustId((long) 4);
        try {
            boolean mak = iCstChance.updateCst(cstChance);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }*/

    //根据用户id查询已分配客户
    @RequestMapping("/getCstCustomer")
    public String getCstCustomer(Model model) {
        Map map = result();
        try {
            Long userIdLong=(Long) session.getAttribute("userId");
            List<CstCustomer> cstCustomerList = iCstChance.getCstCustomer(userIdLong);
            if (cstCustomerList != null) {
                model.addAttribute("cstCustomerList", cstCustomerList);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/createChance";
    }

    //按客户id查询客户关联信息
    @RequestMapping("/getCstCustomerCustId")
    public void  getCstCustomerCustId(HttpServletRequest request, HttpServletResponse response,Long custId) {
        Map map = result();
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            System.out.println(custId + "客户id");
            CstCustomer Customer = iCstChance.getCstCustomerCustId(custId);
            System.out.println("到了没");

            JSONObject JsonObject= JSONObject.fromObject(Customer);

            PrintWriter out = response.getWriter();
            out.print(JsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //按用户id查询已建立转交的机会
    @RequestMapping("/getCstChanceUserId/{currentPage}/{pageSize}")
    public String /*Map*/  getCstChanceUserId(Model model,@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize){
        Map map=result();
        try{
            Long userIdLong=(Long) session.getAttribute("userId");
            Page<CstChance> cstChancesPageList=iCstChance.getCstChanceUserId(userIdLong,currentPage,pageSize);

            List<SysUser> SysUserList=iCstChance.getSysUser(userIdLong);
            if (cstChancesPageList != null) {
                List<Long> arrList = new ArrayList<>();
                Long totalPage = cstChancesPageList.getTotalPage();
                for (int i = 1; i <= totalPage; i++) {
                    arrList.add(new Long(i));
                }
               /* map.put("cstChancePage",cstChancePage);*/
                model.addAttribute("arrList", arrList);
               /* map.put("cstChancesPageList",cstChancesPageList);*/
                model.addAttribute("cstChancesPageList", cstChancesPageList);
                model.addAttribute("SysUserList",SysUserList);
                /*map.put("SysUserList",SysUserList);*/
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*return map;*/
        return "index/refferal";
    }

    //新建转交（按阶段转交）
    @RequestMapping("/addChance/{currentPage}/{pageSize}")
    public String /*Map*/ addChance(Model model,CstChance chance, @PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
         chance.setChStatus("审核中");
         Date date = new Date();
         date.getTime();
         chance.setTransferTime(date);
        try {
                String[] timeStr = chance.getChStage().split(",");
                for (int i = 0; i < timeStr.length; i++) {
                    System.out.println(timeStr[i]);
                    chance.setChStage(timeStr[i]);
                    boolean mask = iCstChance.addChance(chance);
                }
            System.out.println("到了");
          /*if (mask==false){
              map.put("code", "-1");
              map.put("msg", "修改失败");
          }else {
              map.put("msg","添加成功");
          }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:"+"/cstChance/getCstChanceUserId/"+currentPage+"/"+pageSize;
     /*   return map;*/
    }

    //机会转交后的筛选
    @RequestMapping("/getfilterChance/{currentPage}/{pageSize}")
    public /*Map*/String  getfilterChance(Model model,CstChance chance,CstCustomer customer,String begindate,String finishdate,@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
        chance.setChCustomer(customer);
        System.out.println(begindate);

        System.out.println(finishdate);
        if (begindate.length() != 0 && finishdate.length() != 0) {
        String[] timeStr = finishdate.split("-");
        finishdate = begindate + timeStr[1];
        begindate = begindate + timeStr[0];
    }
        System.out.println(begindate);
        System.out.println(finishdate);
         try{
             Page<CstChance> cstChancesPageList=iCstChance.getfilterChance(chance,begindate,finishdate,currentPage,pageSize);
             List<SysUser> SysUserList=iCstChance.getSysUser(chance.getUserId());
             if (cstChancesPageList!=null) {
                 List<Long> arrList = new ArrayList<>();
                 Long totalPage = cstChancesPageList.getTotalPage();
                 System.out.println(totalPage);
                 for (int i = 1; i <= totalPage; i++) {
                     System.out.println(i);
                     arrList.add(new Long(i));
                 }
                 model.addAttribute("arrList", arrList);
                 model.addAttribute("cstChancesPageList", cstChancesPageList);
                 /*map.put("cstChancesPageList", cstChancesPageList);*/
             }else {
                map.put("ChanceList","查询失败");
             }
         }catch (Exception e){
             e.printStackTrace();
         }
       /* return map;*/
       return "index/refferal";
    }

}


