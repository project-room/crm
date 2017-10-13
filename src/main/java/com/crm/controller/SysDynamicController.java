package com.crm.controller;

import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.dynamic.service.ISysDynamicService;
import com.crm.entity.CstSchedule;
import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/9/15.
 */
@RestController
public class SysDynamicController {

    @Autowired
    private ISysDynamicService iSysDynamicService;

    //根据用户id以及limitId和分类查看全部动态
    @RequestMapping("/getDynamicListById")
    public Map selectDynamicByUserId(Long userId,Integer limitId,Integer classify){//classify:分类，当为Null时查所有数据
        Map map= TypeUtil.successMap();
        List<SysDynamic> sysDynamicList = iSysDynamicService.selectDynamicListByUserId((long)2,1,classify);
        map.put("sysDynamic",sysDynamicList);
        return map;
}

    //根据用户Id查询当前日期任务表也要根据状态将不是当前日期的给查出来
    @RequestMapping("/getTaskListByUserId")
    public Map selectTaskByUserId(Long userId){
        Map map= TypeUtil.successMap();
        List<UserTask> sysDynamicList = iSysDynamicService.selectTaskListByUserId((long)1);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //data里返回的是时间戳
//        String s = formatter.format(sysDynamicList.get(0).getTaskDate());
//        System.out.println("日期:" + s);
        map.put("sysDynamic",sysDynamicList);
        return map;
    }









}
