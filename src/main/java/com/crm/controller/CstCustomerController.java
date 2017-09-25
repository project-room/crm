package com.crm.controller;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.common.BaseController;
import com.crm.common.Page;
import com.crm.entity.*;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
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

    @Autowired
    private  ICstCustomerService cstCustomerService;

    /**
     * 获取所有公海客户
     * @return
     */
    @RequestMapping("selectGonghaiCstCustomer")
    public Map index(){
        Map map=TypeUtil.successMap();
      List<CstCustomer> customerList= cstCustomerMapper.selectAllCstCutomer();
      map.put("customerList",customerList);
        return map;
    }

    /**
     * 认领公海客户
     * @return
     */
    @RequestMapping("cliamCstCustomer")
    public Map cliamCstCustomer(){
        Map map=TypeUtil.successMap();
        CstCustomer cstCustomer=new CstCustomer();
        cstCustomer.setUserId(1L);
        cstCustomer.setCustAddress("广州天河");
        cstCustomer.setCustClassify(2);
        cstCustomer.setCustCompany("文档管理");
        cstCustomer.setCustEmail("324224@qq.com");
        cstCustomer.setCustIndustry("软件开发");
        cstCustomer.setCustLifecycle("成交客户");
        cstCustomer.setCustType("代理商");
        cstCustomer.setCustPic("img/4.jpg");
        ChLinkman chLinkman=new ChLinkman();
        chLinkman.setLinkDepartment("销售部");
        chLinkman.setLinkEmail("243242@qq.com");
        chLinkman.setLinkLandlinePhone("34234244");
        chLinkman.setLinkName("黄主管");
        chLinkman.setLinkPhone("13648373738");
        chLinkman.setLinkQq("3424343443");
        chLinkman.setLinkStatus(0);
        cstCustomerService.cliamCstCustomer(cstCustomer,chLinkman);
        return map;
    }

    /**
     * 获取公海客户一页的信息
     * @return
     */
    @RequestMapping("getPageCstCustomer")
    public Map pageCstCustomer(){
        Map map=TypeUtil.successMap();
       List<CstCustomer> cstCustomers= cstCustomerService.getPageCstCustomerInfo(2,2);
       map.put("cstCustomers",cstCustomers);
       return  map;
    }

    /**
     * 获取公海客户的总记录数
     * @return
     */
    @RequestMapping("getCstCustomerCount")
    public Map getCstCustomerCount(){
        Map map=TypeUtil.successMap();
        long count=cstCustomerService.getCstCustomerCount();
        map.put("count",count);
        return map;
    }

    /**
     *通过分页bean获取公海客户信息
     * @return
     */
    @RequestMapping("getPage")
    public Map getPage(){
        Map map=TypeUtil.successMap();
       Page<CstCustomer> cstCustomerPage= cstCustomerService.getCstCustomerOnePageInfo(3,2);
       cstCustomerPage.getCurrentPage();
       cstCustomerPage.getList();
       cstCustomerPage.getPageSize();
       cstCustomerPage.getRecTotal();
       cstCustomerPage.getTotalPage();
       map.put("cstCustomerPage",cstCustomerPage);
        return map;
    }

    /**
     * 显示公海客户信息
     * @return
     */
    @RequestMapping("lookCstCustomerInfo")
    public Map lookCstCustomerInfo(){
        Map map= TypeUtil.successMap();
      CstCustomer cstCustomer=  cstCustomerService.lookCstCustomerInfo(1L);
      map.put("cstCustomer",cstCustomer);
        return map;
    }

    /**
     * 输入客户名称搜索客户
     * @return
     */
    @RequestMapping("selectCstCustomerByName")
    public Map selectCstCustomerByName(){
        Map map=TypeUtil.successMap();
      List<CstCustomer> cstCustomers=  cstCustomerService.selectCstCustomerByName("广州");
      map.put("cstCustomers",cstCustomers);
        return map;
    }
}
