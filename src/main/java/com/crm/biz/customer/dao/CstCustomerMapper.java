package com.crm.biz.customer.dao;

import com.crm.common.Page;
import com.crm.entity.ChLinkman;
import com.crm.entity.CstChance;
import com.crm.entity.CstCustomer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstCustomerMapper{

    CstCustomer findById(Long id);

    void addCstCustomer(CstCustomer cstCustomer);

    void deleteById(Long id);

    void updateCstCustomerById(@Param("cstcustId") Long cstcustId,@Param("cstCustomer") CstCustomer cstCustomer);

    List<CstCustomer> selectAllCstCutomer();

    int saveCstCustomer(CstCustomer cstCustomer);

    List<CstCustomer> getPageCstCustomerInfo(@Param("currentPageLimit") int currentPageLimit,@Param("pageSize") int pageSize);

    Long getCstCustomerCount();

    CstCustomer selectCstCustomerInfo(@Param("cstCustomerId") Long cstCustomerId);

    List<CstCustomer> selectCstCustomerByName(@Param("custCompany") String custCompany);

    void deleteCstCustomerAndChLinkmanById(Long id);

    void saveCstCustomerAndLabel(@Param("cstCustId") Long cstCustId,@Param("labelId") Integer labelId);
}
