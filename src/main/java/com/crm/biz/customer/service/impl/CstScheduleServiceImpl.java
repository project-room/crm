package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.CstScheduleMapper;
import com.crm.biz.customer.service.ICstScheduleService;
import com.crm.entity.CstSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service
public class CstScheduleServiceImpl implements ICstScheduleService{

      @Autowired
      private CstScheduleMapper cstScheduleMapper;

    //根据机会id查询进度表
    @Override
    public List<CstSchedule> getCstSchedule(Long chId) {

        return cstScheduleMapper.getCstSchedule(chId);
    }

    //根据机会id删除进度
    @Override
    public boolean deleteCstSchedule(Long chId) {

        int count=cstScheduleMapper.deleteCstSchedule(chId);
        if (count>0){
           return true;
        }
        return false;
    }
}
