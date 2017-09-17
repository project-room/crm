package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstCustomerServiceImpl implements ICstCustomerService{
    @Autowired
    private CstCustomerMapper cstCustomerMapper;
    @Override
    public CstCustomer getCstCustomer() {
        CstCustomer cstCustomer=null;
        cstCustomer=cstCustomerMapper.findCstCustomer();
        return cstCustomer;
    }

    @Override
    public void addCstCustomerInfo(CstCustomer cstCustomer, CstLowCustomer cstLowCustomer, CstLabel cstLabel) {
        cstCustomerMapper.addCstCustomerInfo(cstCustomer,cstLowCustomer,cstLabel);
    }

    @Override
    public Set<CstCustomer> screenCstCustomers(CstCustomer cstCustomer) {
        Set<CstCustomer> cstCustomers=null;
        cstCustomerMapper.selectAllCstCustomesByScreen(cstCustomer);
        return cstCustomers;
    }

    @Override
    public void deleteCstCustomer(Long cstCustomerId) {
        cstCustomerMapper.deleteById(cstCustomerId);
    }
}
