package com.crm.biz.dynamic.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Component
public interface SysDynamicMapper {
    SysDynamic findById(Long id);

    void addSysDynamic(SysDynamic sysDynamic);

    void deleteById(Long id);

    void updateSysDynamicById(SysDynamic sysDynamic);

    //根据用户id查询所有动态
    List<SysDynamic> selectDynamicListByUserId(@Param("userId") Long userId,@Param("limitId")int limitId);

    //根据用户Id查询当前日期的任务
    List<UserTask> selectTaskListByUserId(@Param("userId")Long userId,@Param("taskStatus")Integer taskStatus);

    void insertTaskTest(UserTask userTask);
}
