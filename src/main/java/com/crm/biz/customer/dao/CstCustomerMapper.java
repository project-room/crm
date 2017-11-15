package com.crm.biz.customer.dao;

import com.crm.common.Page;
import com.crm.dto.CstCustomerDto;
import com.crm.entity.ChLinkman;
import com.crm.entity.CstChance;
import com.crm.entity.CstCustomer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    List<CstCustomer> getPageCstCustomerInfo(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName,@Param("currentPageLimit") int currentPageLimit, @Param("pageSize") int pageSize);

    Long getCstCustomerCount(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName);

    CstCustomer selectCstCustomerInfo(@Param("cstCustomerId") Long cstCustomerId);

    //根据模糊客户名来获取客户信息
    List<CstCustomer> selectCstCustomerByName(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName,@Param("custCompany") String custCompany,@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    void deleteCstCustomerAndChLinkmanById(Long id);

    void saveCstCustomerAndLabel(@Param("cstCustId") Long cstCustId,@Param("labelId") Integer labelId);

    //根据机会对象里的客户id修改客户表里的用户id
    int updateCstCustomer(CstChance cstChance);

    //根据条件筛选客户
    List<CstCustomer>  selectCstCustomerByCondition(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName,@Param("userName") String userName, @Param("startTimeDate") Date startTimeDate,@Param("endTimeDate") Date endTimeDate, @Param("cstCustomer") CstCustomer cstCustomer, @Param("chLinkman") ChLinkman chLinkman, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //筛选客户
    Long getCountByCondition(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName,@Param("userNameLike") String userNameLike,@Param("startTimeDate") Date startTimeDate,@Param("endTimeDate") Date endTimeDate,@Param("cstCustomer") CstCustomer cstCustomer,@Param("chLinkman") ChLinkman chLinkman);

    //根据模糊客户名来获取count
    Long selectCountByCstCustomerName(@Param("userIdForPage") Long userIdForPage,@Param("roleName") String roleName,@Param("custCompany") String custCompany);

    //根据公海客户id修改客户信息
    void updateCstCustomerWithId(@Param("cstcustId") Long cstcustId,@Param("cstCustomer") CstCustomer cstCustomer);

}
