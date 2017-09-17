package com.crm.biz.customer.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstCustomerMapper{
    @Select("select * from cst_customer")
    @Results({
            @Result(property ="custName",column = "cust_name"),
            @Result(property ="custPhone",column = "cust_phone"),
            @Result(property ="custEmail",column = "cust_email"),
            @Result(property ="custCompany",column = "cust_company"),
            @Result(property ="custAddress",column = "cust_address"),
            @Result(property ="custIndustry",column = "cust_industry"),
            @Result(property ="custPic",column = "cust_name"),
            @Result(property ="custSales",column = "cust_sales"),
            @Result(property ="userId",column = "user_id"),
            @Result(property ="ctime",column = "ctime",javaType = Date.class)
    })
    CstCustomer findCstCustomer();

//    CstCustomer findById(@Param("id") Long id);

    /**
     * 添加用户信息
     * @param cstCustomer
     */
    void addCstCustomerInfo(CstCustomer cstCustomer, CstLowCustomer cstLowCustomer, CstLabel cstLabel);

    /**
     * 筛选客户
     * @param cstCustomer
     * @return
     */
    Set<CstCustomer> selectAllCstCustomesByScreen(CstCustomer cstCustomer);

    /**
     * 删除客户id
     * @param id
     */
    void deleteById(Long id);
}
