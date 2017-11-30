package com.crm.biz.dynamic.service.impl;

import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.dynamic.service.ISysDynamicService;
import com.crm.entity.SysDynamic;
import com.crm.entity.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Service
public class SysDynamicServiceImpl implements ISysDynamicService {

    @Autowired
    private SysDynamicMapper sysDynamicMapper;

    public List<SysDynamic> selectDynamicListByUserId(Long userId,Integer lastId,Integer classify){
        if(classify != null){
            //在这里判断当有分类传进来时传出带有分类的数据
        }
        return sysDynamicMapper.selectDynamicListByUserId(userId,lastId);
    }

    public List<UserTask> selectTaskListByUserId(Long userId){
        System.out.println(userId);
        return sysDynamicMapper.selectTaskListByUserId(userId,0);
    }


    public void updateTask(Long taskId,Integer taskStatus){
        if(taskStatus == 0){//0：未完成   1:已完成
            sysDynamicMapper.updateTask(taskId,1);
        }else{
            sysDynamicMapper.updateTask(taskId,0);
        }

    }

    @Override
    public List<SysDynamic> selectDynamicAll(Long userId,Long roleId) {
        return sysDynamicMapper.selectDynamicAll(userId,roleId);
    }

}
