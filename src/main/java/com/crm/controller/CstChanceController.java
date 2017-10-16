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
    public Map getCstChance() {
        Map map = TypeUtil.successMap();
        Long userId = (long) 1;
        int currentPage = 1;
        int pageSize = 2;
        Page<CstChance> cstChancePage = iCstChance.getCstChance(userId, currentPage, pageSize);
        map.put("cstChancePage", cstChancePage);
        return map;
    }

    //添加方法
    @RequestMapping("/addCstChance")
    public Map addCstChance(CstChance cstChance) {

        Map map = TypeUtil.successMap();

        boolean mak = false;

        mak = iCstChance.addCstChance(cstChance);
        if (mak == true) {
            map.put("mak", "添加成功");
        } else {
           map.put("mak", "添加失败");
        }
        return map;
    }

    //按机会id查询机会的详细信息
    @RequestMapping("/getCstChanceId")
    public Map getCstChanceId() {
        Map map = TypeUtil.successMap();
        Long chId = (long) 1;
        CstChance cstChance = iCstChance.getCstChanceId(chId);

        Boolean by = ObjectUtil.isNotNull(cstChance);
        if (by == true) {
            map.put("cstChance", cstChance);
        } else {
            map.put("cstChance", "查询失败，对象为空");
        }
        return map;
    }

    //删除方法
    @RequestMapping("/deleteCstChance")
    public Map deleteCstChance() {
        Map map = TypeUtil.successMap();
        boolean mak = false;
        Long id = (long) 15;
        mak = iCstChance.deleteCstChance(id);
        iUserTaskService.deleteUserTaskChId(id);
        iCstRecordService.deleteCstRecordChId(id);
        iCstScheduleService.deleteCstSchedule(id);
        if (mak == true) {
            map.put("mak", "删除成功");
        } else {
            map.put("mak", "删除失败");
        }
        return map;
    }

    //修改方法
    @RequestMapping("/updateCstChance")
    public Map updateCstChance(CstChance cstChance) {
        Map map = TypeUtil.successMap();

        boolean mak = iCstChance.updateCstChance(cstChance);

        if (mak == true) {
            map.put("mak", "修改成功");
        } else {
            map.put("mak", "修改失败");
        }
        return map;
    }

    //查询有多少条机会信息
    @RequestMapping("/getCstChanceCount")
    public Map getCstChanceCount() {
        Map map = TypeUtil.successMap();
        Long userId = (long) 1;
        int count = iCstChance.getCstChanceCount(userId);
        map.put("count", count);
        return map;
    }

    //根据条件查询
    @RequestMapping("/getCstChanceTo")
    public Map getCstChanceTo() {
        Map map = TypeUtil.successMap();
        CstChance cstChance = new CstChance();
        cstChance.setUserId((long) 1);
        int currentPage = 1;
        int pageSize = 2;
        Page<CstChance> ChancePage = iCstChance.getCstChanceTo(cstChance, currentPage, pageSize);
        map.put("ChancePage", ChancePage);
        return map;
    }


    //转交客户
    @RequestMapping("/updateChance")
    public Map updateChance() {
        Map map = TypeUtil.successMap();
        CstChance cst = new CstChance();
        cst.setChId((long) 3);
        cst.setUserId((long) 2);
        cst.setUserName("李白");
        cst.setCustId((long) 4);
        boolean mak = iCstChance.updateChance(cst);
        if (mak == true) {
            map.put("mak", "修改成功");
        } else {
            map.put("mak", "修改失败");
        }
        return map;
    }

    //按阶段来转交客户
    @RequestMapping("/updateCst")
    public Map updateCst() {
        Map map = TypeUtil.successMap();
        CstChance cstChance = new CstChance();
        cstChance.setChStage("签订合同");
        cstChance.setUserId((long) 3);
        cstChance.setUserName("张飞");
        cstChance.setCustId((long) 4);
        boolean mak = iCstChance.updateCst(cstChance);
        if (mak == true) {
            map.put("mak", "修改成功");
        } else {
            map.put("mak", "修改失败");
        }
        return map;
    }
}



