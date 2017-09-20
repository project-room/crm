package com.crm.biz.customer.dao;

import java.util.List;

import com.crm.entity.CstCustomer;
import com.crm.entity.CstCustomerExample;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
=======
>>>>>>> crm/eee
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

<<<<<<< HEAD
@Component
public interface CstCustomerMapper {
    int countByExample(CstCustomerExample example);

    int deleteByExample(CstCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    List<CstCustomer> selectByExample(CstCustomerExample example);

    CstCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByExample(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);
}
=======
import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstCustomerMapper{
    int countByExample(CstCustomerExample example);

    int deleteByExample(CstCustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    List<CstCustomer> selectByExample(CstCustomerExample example);

    CstCustomer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByExample(@Param("record") CstCustomer record, @Param("example") CstCustomerExample example);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);

    CstCustomer selectLabelList(Long custId);
}
>>>>>>> crm/eee
