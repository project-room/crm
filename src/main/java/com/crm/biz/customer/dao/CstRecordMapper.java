package com.crm.biz.customer.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.CstRecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CstRecordMapper {
    CstRecord findById(Long id);

    void addCstRecord(CstRecord cstRecord);

    void deleteById(Long id);

    void updateCstRecordById(CstRecord cstRecord);
}