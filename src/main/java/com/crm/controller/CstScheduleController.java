package com.crm.controller;

import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.biz.customer.service.ICstScheduleService;
import com.crm.common.BaseController;
import com.crm.entity.CstRecord;
import com.crm.entity.CstSchedule;

import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/15.
 */
@RestController
public class CstScheduleController extends BaseController {
    @Autowired
    private CstScheduleMapper cstScheduleMapper;

    @Autowired
    private ICstScheduleService iCstScheduleService;

    @RequestMapping("selectCstScheduleById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstSchedule cstSchedule=cstScheduleMapper.findById(1l);
        map.put("cstSchedule",cstSchedule);
        return map;
    }

    //按机会id查询进度表
    @RequestMapping("/getCstSchedule")
    public Map getCstSchedule(Long chId){
        Map map= result();
        try {
            List<CstSchedule> cstScheduleList = iCstScheduleService.getCstSchedule(chId);
            Boolean by = ObjectUtil.isNotNull(cstScheduleList);
            if (by) {
                map.put("cstScheduleList", cstScheduleList);
            } else {
                map.put("-1", "查询失败，对象为空");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return  map;
    }
}
