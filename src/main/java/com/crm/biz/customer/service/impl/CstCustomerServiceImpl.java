package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.ChLinkmanMapper;
import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.common.Page;
import com.crm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstCustomerServiceImpl implements ICstCustomerService{
    @Autowired
    private CstCustomerMapper cstCustomerMapper;
    @Autowired
    private ChLinkmanMapper chLinkmanMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public void cliamCstCustomer(CstCustomer cstCustomer, ChLinkman chLinkman) {

        cstCustomerMapper.saveCstCustomer(cstCustomer);
        //插入客户信息返回客户id
        Long custId=cstCustomer.getCustId();
        chLinkman.setCustId(custId);
        chLinkmanMapper.saveChLinkman(chLinkman);
    }

    @Override
    public Page<CstCustomer> getCstCustomerOnePageInfo(int currentPage, int pageSize) {
        Long count=cstCustomerMapper.getCstCustomerCount();
       int currentPageLimit=currentPage-1;
       List<CstCustomer> cstCustomers= cstCustomerMapper.getPageCstCustomerInfo(currentPageLimit,pageSize);
        return new Page<CstCustomer>(currentPage,pageSize,cstCustomers,count);
    }

    @Override
    public CstCustomer lookCstCustomerInfo(Long cstCustomerId) {
     CstCustomer reCstCustomer=  cstCustomerMapper.selectCstCustomerInfo(cstCustomerId);
        return reCstCustomer;
    }

    @Override
    public List<CstCustomer> selectCstCustomerByName(String custCompany) {
        custCompany="%"+custCompany+"%";
     List<CstCustomer>  cstCustomers= cstCustomerMapper.selectCstCustomerByName(custCompany);
        return cstCustomers;
    }

    @Override
    public List<CstCustomer> selectAllCstCutomer() {
        return cstCustomerMapper.selectAllCstCutomer();
    }


}
