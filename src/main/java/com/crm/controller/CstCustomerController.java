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

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/19.
 */
@RestController
public class CstCustomerController extends BaseController{
    @Autowired
    private CstCustomerMapper cstCustomerMapper;
    @RequestMapping("getId")
    public Map index(){
        Map map=TypeUtil.successMap();
        //根据id查找
      CstCustomer cstCustomer=  cstCustomerMapper.findById(1L);

        //增
//        CstCustomer cstCustomer=new CstCustomer();
//        cstCustomer.setCustName("加入了吗");
//        cstCustomerMapper.addCstCustomer(cstCustomer);

        //根据id删除
//        cstCustomerMapper.deleteById(4L);

//        CstCustomer cstCustomer=new CstCustomer();
//        cstCustomer.setCustId(2l);
//        cstCustomer.setCustPhone("10086");
        //根据Id修改
//        cstCustomerMapper.updateCstCustomerById(cstCustomer);
      map.put("cstCustomer",cstCustomer);
        return map;
    }


















//    @Autowired
//    private CstCustomerMapper cstCustomerMapper;
//    @Autowired
//    private ICstCustomerService cstCustomerService;
//
//
//
//    @RequestMapping("/get")
//    public Map getCstCustomer(){
//        Map map= TypeUtil.successMap();
//        CstCustomer cstCustomer=cstCustomerMapper.selectByPrimaryKey(1L);
//        map.put("cstCustomer",cstCustomer);
//        return map;
//    }
//
//
//    @RequestMapping("/getId/{1}")
//    public CstCustomer getCstCustomerBy(@PathVariable("id") Long id){
//        CstCustomer cstCustomer=null;
////        cstCustomer=cstCustomerMapper.findById(id);
//        return cstCustomer;
//    }
//
//    /**
//     * 新建客户
//     * @param cstCustomer
//     */
//    @RequestMapping("/addCstCustomerInfo")
//    public Map addCstCustomerInfo(CstCustomer cstCustomer, CstLowCustomer cstLowCustomer, CstLabel cstLabel){
//        Map map=TypeUtil.successMap();
//        cstCustomerService.addCstCustomerInfo(cstCustomer,cstLowCustomer,cstLabel);
//        return map;
//    }
//
//    /**
//     * 筛选客户
//     * @param cstCustomer
//     * @return
//     */
//    @RequestMapping("/screenCstCustomers")
//    public Map screenCstCustomers(CstCustomer cstCustomer){
//        Map map=TypeUtil.successMap();
//        cstCustomerService.screenCstCustomers(cstCustomer);
//        return map;
//    }
//
//    /**
//     * 删除客户
//     * @param cstCustomerId
//     * @return
//     */
//    public Map deleteCstCustomer(Long cstCustomerId){
//        Map map=TypeUtil.successMap();
//        cstCustomerService.deleteCstCustomer(cstCustomerId);
//        return map;
//    }
//
//    /**
//     * 根据用户名查询用户
//     * @param CstCustomerName
//     * @return
//     */
//    public Map searchByCstCustomerName(String CstCustomerName){
//        Map map=TypeUtil.successMap();
//       Set<CstCustomer> cstCustomers= cstCustomerService.searchByCstCustomerName(CstCustomerName);
//       map.put("cstCustomers",cstCustomers);
//        return map;
//    }
//
//    /**
//     * 编辑客户信息
//     * @param cstCustomer
//     */
//    public Map editorCstCustomer(CstCustomer cstCustomer){
//        Map map =TypeUtil.successMap();
//        cstCustomerService.editorCstCustomer(cstCustomer);
//        return map;
//    }
//
//    /***
//     * 通过客户id查询标签
//     */
//    @RequestMapping("/getCstLabel")
//    public Map selectCstLabel(CstCustomer cstCustomer){
//        Map map=TypeUtil.successMap();
//        CstCustomer cstCustomer1 = cstCustomerService.selectLabelList((long) 1);
//        map.put("cstLabelList",cstCustomer1.getLabelList());
//        return map;
//    }
}
