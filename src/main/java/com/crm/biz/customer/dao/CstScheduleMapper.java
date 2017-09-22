package com.crm.biz.customer.dao;

import com.crm.entity.CstRecord;
import com.crm.entity.CstSchedule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Component
public interface CstScheduleMapper {
    CstSchedule findById(Long id);

    void addCstSchedule(CstSchedule cstSchedule);

    void deleteById(Long id);

    void updateCstScheduleById(CstSchedule cstSchedule);
}
