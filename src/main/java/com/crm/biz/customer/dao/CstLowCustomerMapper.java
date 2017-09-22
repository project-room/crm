package com.crm.biz.customer.dao;

import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstLowCustomerMapper  {
    CstLowCustomer findById(Long id);

    void addCstLowCustomer(CstLowCustomer cstLowCustomer);

    void deleteById(Long id);

    void updateCstLowCustomerById(CstLowCustomer cstLowCustomer);
}
