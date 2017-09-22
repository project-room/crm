package com.crm.controller;

import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.common.BaseController;
import com.crm.entity.CstLowCustomer;
import com.crm.entity.CstRecord;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class CstRecordController extends BaseController{
    @Autowired
    private CstRecordMapper cstRecordMapper;
    @RequestMapping("selectCstRecordById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstRecord cstRecord=cstRecordMapper.findById(1l);
        map.put("cstRecord",cstRecord);
        return map;
    }
}
