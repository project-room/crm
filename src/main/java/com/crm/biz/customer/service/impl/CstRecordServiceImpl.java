package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.entity.CstRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstRecordServiceImpl implements ICstRecordService{

     @Autowired
     private CstRecordMapper cstRecordMapper;

    @Override
    public List<CstRecord> getCstRecord(Long id) {
        System.out.println("到了没");
        return cstRecordMapper.getCstRecord(id);
    }

    //添加记录方法
    @Override
    public boolean addCstRecord(CstRecord cstRecord) {

        int count=cstRecordMapper.addRecord(cstRecord);
        if (count>0){
            return true;
        }
        return false;
    }

    //删除一条记录方法
    @Override
    public boolean deleteCstRecord(Long reId) {

        int count=cstRecordMapper.deleteCstRecord(reId);
        if(count>0){
            return true;
        }
        return false;
    }

    //根据机会id删除记录
    @Override
    public boolean deleteCstRecordChId(Long chId) {
        int count=cstRecordMapper.deleteCstRecordChId(chId);
        if(count>0){
            return true;
        }
        return false;
    }

    //查询一天机会的总记录条数
    @Override
    public int getRecordCount(Long chId) {

        return cstRecordMapper.getRecordCount(chId);
    }

    //修改一条记录方法
    @Override
    public boolean updateCstRecord(CstRecord Record) {

        int count=cstRecordMapper.updateCstRecord(Record);

        if(count>0){
            return true;
        }
        return false;
    }


}

