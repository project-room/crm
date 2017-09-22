package com.crm.biz.customer.dao;

import com.crm.entity.CstCustomer;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstCustomerMapper{

    CstCustomer findById(Long id);

    void addCstCustomer(CstCustomer cstCustomer);

    void deleteById(Long id);

    void updateCstCustomerById(CstCustomer cstCustomer);

}
