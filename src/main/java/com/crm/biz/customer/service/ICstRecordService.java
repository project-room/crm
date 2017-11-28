package com.crm.biz.customer.service;

import com.crm.entity.CstRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ICstRecordService {


    public List<CstRecord> getCstRecord(Long id);

    public boolean addCstRecord(CstRecord cstRecord);

    public  boolean deleteCstRecord(Long reId);

    public boolean updateCstRecord(CstRecord Record);

    public boolean deleteCstRecordChId(Long chId);

    public int getRecordCount(Long chId);

}
