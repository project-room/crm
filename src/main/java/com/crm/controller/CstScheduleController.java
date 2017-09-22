package com.crm.controller;

import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.entity.CstRecord;
import com.crm.entity.CstSchedule;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/15.
 */
@RestController
public class CstScheduleController {
    @Autowired
    private CstScheduleMapper cstScheduleMapper;
    @RequestMapping("selectCstScheduleById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstSchedule cstSchedule=cstScheduleMapper.findById(1l);
        map.put("cstSchedule",cstSchedule);
        return map;
    }
}
