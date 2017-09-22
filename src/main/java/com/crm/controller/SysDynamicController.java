package com.crm.controller;

import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.entity.CstSchedule;
import com.crm.entity.SysDynamic;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/15.
 */
@RestController
public class SysDynamicController {
    @Autowired
    private SysDynamicMapper sysDynamicMapper;
    @RequestMapping("selectSysDynamicById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        SysDynamic sysDynamic=sysDynamicMapper.findById(1l);
        map.put("sysDynamic",sysDynamic);
        return map;
    }
}
