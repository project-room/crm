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

    int saveCstRecord(CstRecord cstRecord);


    //按机会id查讯记录表
    List<CstRecord> getCstRecord(Long id);

    //添加记录
    int addRecord(CstRecord cstRecord);

    //删除一条记录
    int deleteCstRecord(Long reId);

    //根据机会id删除删除记录
    int deleteCstRecordChId(Long chId);

    //修改一条记录
    int updateCstRecord(CstRecord Record);

}