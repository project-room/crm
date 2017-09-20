package com.crm.controller;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.common.BaseController;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstCustomerExample;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/19.
 */
@RestController
public class CstCustomerController extends BaseController{
    @Autowired
    private CstCustomerMapper cstCustomerMapper;

    @RequestMapping("test")
    public Map test(){
        Map map= TypeUtil.successMap();
        CstCustomer cstCustomer=cstCustomerMapper.selectByPrimaryKey(1L);
        map.put("cstCustomer",cstCustomer);
        return map;
    }
}
