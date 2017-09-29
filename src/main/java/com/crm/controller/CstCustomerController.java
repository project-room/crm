package com.crm.controller;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.common.BaseController;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
//    @RequestMapping("selectGonghaiCstCustomer")
//    public Map index(){
//        Map map=TypeUtil.successMap();
//      List<CstCustomer> customerList= cstCustomerMapper.selectAllCstCutomer();
//      map.put("customerList",customerList);
//        return map;
//    }
}
