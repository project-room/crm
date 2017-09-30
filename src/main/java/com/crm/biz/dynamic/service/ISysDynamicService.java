package com.crm.biz.dynamic.service;

import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface ISysDynamicService {

    //通过用户id查询所有动态
    List<SysDynamic> selectDynamicListByUserId(Long userId,Integer limitId,Integer classify);

    //通过用户id查询当前日期的任务表
    List<UserTask> selectTaskListByUserId(Long userId);

}
