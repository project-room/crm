package com.crm.controller;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.common.BaseController;
import com.crm.entity.CstChance;
import com.crm.entity.CstLowCustomer;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class CstLowCustController extends BaseController{
    @Autowired
    private CstLowCustomerMapper cstLowCustomerMapper;
    @RequestMapping("selectCstLowCustomerById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstLowCustomer cstLowCustomer=cstLowCustomerMapper.findById(1l);
        map.put("cstLowCustomer",cstLowCustomer);
        return map;
     }
}
