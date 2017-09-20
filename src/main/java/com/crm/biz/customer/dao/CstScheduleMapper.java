package com.crm.biz.customer.dao;

import com.crm.entity.CstSchedule;
import com.crm.entity.CstScheduleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface CstScheduleMapper {

    int countByExample(CstScheduleExample example);

    int deleteByExample(CstScheduleExample example);

    int deleteByPrimaryKey(Long scheId);

    int insert(CstSchedule record);

    int insertSelective(CstSchedule record);

    List<CstSchedule> selectByExample(CstScheduleExample example);

    CstSchedule selectByPrimaryKey(Long scheId);

    int updateByExampleSelective(@Param("record") CstSchedule record, @Param("example") CstScheduleExample example);

    int updateByExample(@Param("record") CstSchedule record, @Param("example") CstScheduleExample example);

    int updateByPrimaryKeySelective(CstSchedule record);

    int updateByPrimaryKey(CstSchedule record);


}
