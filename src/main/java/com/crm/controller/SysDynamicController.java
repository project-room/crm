package com.crm.controller;

import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.dynamic.service.ISysDynamicService;
import com.crm.common.BaseController;
import com.crm.entity.CstSchedule;
import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
/*@RestController*/
@Controller
public class SysDynamicController extends BaseController {

    @Autowired
    private ISysDynamicService iSysDynamicService;

    //根据用户id以及lastId和分类查看全部动态，lastId为最后一个值的dy_id
    @RequestMapping("/getDynamicListById")
    public Map selectDynamicByUserId(Long userId,Integer lastId,Integer classify){//classify:分类，当为Null时查所有数据
        Map map= TypeUtil.successMap();
        try {
            List<SysDynamic> sysDynamicList = iSysDynamicService.selectDynamicListByUserId((long)userId,lastId,classify);
            map.put("sysDynamic",sysDynamicList);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","查询动态表失败");
        }
        return map;
}

    //根据用户Id查询当前日期任务表也要根据状态将不是当前日期的给查出来
    @RequestMapping("/getTaskListByUserId")
    public String selectTaskByUserId(Model model){
        Map map= TypeUtil.successMap();
        Long userId=(Long)session.getAttribute("userId");
        try {
            System.out.println(userId);
          List<UserTask> sysDynamicList = iSysDynamicService.selectTaskListByUserId(userId);
            System.out.println("到了吗");
            if(sysDynamicList!=null){
                model.addAttribute("sysDynamicList",sysDynamicList);
            }
            else {
                System.out.println("对象为空");
                model.addAttribute("对象为空",sysDynamicList);
            }
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //data里返回的是时间戳
//        String s = formatter.format(sysDynamicList.get(0).getTaskDate());
//        System.out.println("日期:" + s);
         /*  map.put("sysDynamic",sysDynamicList);*/
         } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","任务列表查询失败");
        }
        return "index/index";
    }


    //修改任务中的状态，当状态为未完成时修改为已完成，状态为已完成时修改成未完成
    @RequestMapping("/updateTask")
    public Map updateTask(Long taskId,Integer taskStatus){
        Map map= TypeUtil.successMap();
        try {
        iSysDynamicService.updateTask(taskId,taskStatus);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","任务状态修改失败");
        }
        return map;
    }
}
