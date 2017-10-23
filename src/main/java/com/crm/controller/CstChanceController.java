package com.crm.controller;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.biz.customer.service.ICstScheduleService;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.entity.CstChance;
import com.crm.entity.CstSchedule;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 * ZHB
 */
@RestController
public class CstChanceController extends BaseController {

    @Autowired
    private ICstChanceService iCstChance;

    @Autowired
    private IUserTaskService iUserTaskService;

    @Autowired
    private ICstRecordService iCstRecordService;

    @Autowired
    private ICstScheduleService iCstScheduleService;


    //查询我的机会方法
    @RequestMapping("/getCstChance")
    public Map getCstChance(Long userId ,@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map = result();
 //       Long userId = (long) 1;
 //       int currentPage = 1;
  //      int pageSize = 2;
        try {
            Page<CstChance> cstChancePage = iCstChance.getCstChance(userId, currentPage, pageSize);
            Boolean by = ObjectUtil.isNotNull(cstChancePage);
            if (by) {
                 map.put("cstChancePage", cstChancePage);
            }else {
                  map.put("-1","查询失败");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //机会添加方法
    @RequestMapping("/addCstChance")
    public Map addCstChance(CstChance cstChance) {
         Map map=result();
        try {
            boolean mak = iCstChance.addCstChance(cstChance);
           if (mak==false) {
               map.put("code", "-1");
               map.put("msg","修改失败");
           }
       } catch (Exception e){
           e.printStackTrace();
       }
        return map;
    }

    //按机会id查询机会的详细信息
    @RequestMapping("/getCstChanceId")
    public Map getCstChanceId(Long chId) {
        Map map=result();
  //      Long chId = (long) 1;
        try{
            CstChance cstChance = iCstChance.getCstChanceId(chId);
            Boolean by = ObjectUtil.isNotNull(cstChance);
                if (by) {
               map.put("cstChance", cstChance);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    //删除方法
    @RequestMapping("/deleteCstChance")
    public Map deleteCstChance(Long id) {
        Map map=result();
      //  Long id = (long) 15;
        try {
            boolean   mak = iCstChance.deleteCstChance(id);
            iUserTaskService.deleteUserTaskChId(id);
            iCstRecordService.deleteCstRecordChId(id);
            iCstScheduleService.deleteCstSchedule(id);
            if (mak==false) {
                map.put("code", "-1");
                map.put("msg","修改失败");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    //修改方法
    @RequestMapping("/updateCstChance")
    public Map updateCstChance(CstChance cstChance) {
          Map map=result();
        try {
            boolean mak = iCstChance.updateCstChance(cstChance);
            if (mak==false) {
                map.put("code", "-1");
                map.put("msg","修改失败");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    //查询有多少条机会信息
    @RequestMapping("/getCstChanceCount")
    public Map getCstChanceCount( Long userId) {
        Map map=result();
   //     Long userId = (long) 1;
        try {
            int count = iCstChance.getCstChanceCount(userId);
            map.put("count", count);
         } catch (Exception e){
            e.printStackTrace();
         }
        return map;
    }

    //根据条件查询
    @RequestMapping("/getCstChanceTo")
    public Map getCstChanceTo(CstChance cstChance, @PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        Map map=result();
 //  CstChance cstChance = new CstChance();
    //    cstChance.setUserId((long) 1);
     //   int currentPage = 1;
   //     int pageSize = 2;
        try {
            Page<CstChance> ChancePage = iCstChance.getCstChanceTo(cstChance, currentPage, pageSize);
            Boolean by = ObjectUtil.isNotNull(ChancePage);
            if (by) {
                map.put("ChancePage", ChancePage);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    //转交客户
    @RequestMapping("/updateChance")
    public Map updateChance(CstChance cst) {
          Map map=result();
//        CstChance cst = new CstChance();
//        cst.setChId((long) 3);
//        cst.setUserId((long) 2);
//        cst.setUserName("李白");
//        cst.setCustId((long) 4);
        try {
            boolean mak = iCstChance.updateChance(cst);
            if (mak==false) {
                map.put("code", "-1");
                map.put("msg","修改失败");
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        return map;
    }

    //按阶段来转交客户
    @RequestMapping("/updateCst")
    public Map updateCst(CstChance cstChance) {
          Map map=result();
//        CstChance cstChance = new CstChance();
//        cstChance.setChStage("签订合同");
//        cstChance.setUserId((long) 3);
//        cstChance.setUserName("张飞");
//        cstChance.setCustId((long) 4);
         try {
             boolean mak = iCstChance.updateCst(cstChance);
             if (mak==false) {
                 map.put("code", "-1");
                 map.put("msg","修改失败");
             }
         } catch (Exception e){
             e.printStackTrace();
         }
        return map;
    }
}



