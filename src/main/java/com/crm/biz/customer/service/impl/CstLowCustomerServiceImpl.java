package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.service.ICstLowCustService;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.entity.CstLowCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstLowCustomerServiceImpl implements ICstLowCustService{

    @Autowired
    private CstLowCustomerMapper cstLowCustomerMapper;


    @Override
    public boolean addCstLowCust(CstLowCustomer cstLowCustomer) {
        int count=cstLowCustomerMapper.addCstLowCust(cstLowCustomer);
        if (count>1){
            return true;
        }
        return false;
    }
}
