package com.crm.biz.dynamic.service;

import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface ISysDynamicService {

    //通过用户id查询所有动态
    List<SysDynamic> selectDynamicListByUserId(Long userId,Integer lastId,Integer classify);

    //通过用户id查询当前日期的任务表
    List<UserTask> selectTaskListByUserId(Long userId);

    //修改任务中的状态，当状态为未完成时修改为已完成，状态为已完成时修改成未完成
    void updateTask(Long taskId,Integer taskStatus);

    //查询所有动态信息
    List<SysDynamic> selectDynamicAll(Long userId,Long roleId);

}
