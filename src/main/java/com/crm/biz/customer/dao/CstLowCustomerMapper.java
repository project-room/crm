package com.crm.biz.customer.dao;

import com.crm.entity.CstLowCustomer;
import com.crm.entity.CstLowCustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface CstLowCustomerMapper  {
    int countByExample(CstLowCustomerExample example);

    int deleteByExample(CstLowCustomerExample example);

    int deleteByPrimaryKey(Long lowCustId);

    int insert(CstLowCustomer record);

    int insertSelective(CstLowCustomer record);

    List<CstLowCustomer> selectByExample(CstLowCustomerExample example);

    CstLowCustomer selectByPrimaryKey(Long lowCustId);

    int updateByExampleSelective(@Param("record") CstLowCustomer record, @Param("example") CstLowCustomerExample example);

    int updateByExample(@Param("record") CstLowCustomer record, @Param("example") CstLowCustomerExample example);

    int updateByPrimaryKeySelective(CstLowCustomer record);

    int updateByPrimaryKey(CstLowCustomer record);
}
