package com.crm.controller;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.common.BaseController;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import com.crm.utils.TypeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class CstCustomerController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CstCustomerController.class);
    @Autowired
    private ICstCustomerService cstCustomerService;
    @Autowired
    private CstCustomerMapper cstCustomerMapper;


    @RequestMapping("/get")
    public Map getCstCustomer(){
        Map map= TypeUtil.successMap();
        CstCustomer cstCustomer=null;
        cstCustomer=cstCustomerService.getCstCustomer();
        map.put("cstCustomer",cstCustomer);
        return map;
    }

    @RequestMapping("/getId/{1}")
    public CstCustomer getCstCustomerBy(@PathVariable("id") Long id){
        CstCustomer cstCustomer=null;
//        cstCustomer=cstCustomerMapper.findById(id);
        return cstCustomer;
    }

    /**
     * 新建客户
     * @param cstCustomer
     */
    @RequestMapping("/addCstCustomerInfo")
    public Map addCstCustomerInfo(CstCustomer cstCustomer, CstLowCustomer cstLowCustomer, CstLabel cstLabel){
        Map map=TypeUtil.successMap();
        cstCustomerService.addCstCustomerInfo(cstCustomer,cstLowCustomer,cstLabel);
        return map;
    }

    /**
     * 筛选客户
     * @param cstCustomer
     * @return
     */
    @RequestMapping("/screenCstCustomers")
    public Map screenCstCustomers(CstCustomer cstCustomer){
        Map map=TypeUtil.successMap();
        cstCustomerService.screenCstCustomers(cstCustomer);
        return map;
    }

    /**
     * 删除客户
     * @param cstCustomerId
     * @return
     */
    public Map deleteCstCustomer(Long cstCustomerId){
        Map map=TypeUtil.successMap();
        cstCustomerService.deleteCstCustomer(cstCustomerId);
        return map;
    }

    /**
     * 根据用户名查询用户
     * @param CstCustomerName
     * @return
     */
    public Map searchByCstCustomerName(String CstCustomerName){
        Map map=TypeUtil.successMap();
       Set<CstCustomer> cstCustomers= cstCustomerService.searchByCstCustomerName(CstCustomerName);
       map.put("cstCustomers",cstCustomers);
        return map;
    }

    /**
     * 编辑客户信息
     * @param cstCustomer
     */
    public Map editorCstCustomer(CstCustomer cstCustomer){
        Map map =TypeUtil.successMap();
        cstCustomerService.editorCstCustomer(cstCustomer);
        return map;
    }

    /***
     * 通过客户id查询标签
     */
    @RequestMapping("/getCstLabel")
    public Map selectCstLabel(CstCustomer cstCustomer){
        Map map=TypeUtil.successMap();
        CstCustomer cstCustomer1 = cstCustomerService.selectLabelList((long) 1);
        map.put("cstLabelList",cstCustomer1.getLabelList());
        return map;
    }

}
