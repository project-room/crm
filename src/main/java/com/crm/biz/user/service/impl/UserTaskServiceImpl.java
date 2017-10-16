package com.crm.biz.user.service.impl;

import com.crm.biz.user.dao.UserTaskMapper;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.entity.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
@Service
public class UserTaskServiceImpl implements IUserTaskService {

    @Autowired
    private  UserTaskMapper userTaskMapper;


    //按机会id查询任务
    @Override
    public List<UserTask> getUserTask(Long chId){

        return userTaskMapper.getUserTask(chId);
    }

    //删除一条任务
    @Override
    public boolean deleteUserTask(Long taskId) {
        int count=userTaskMapper.deleteUserTask(taskId);
        if(count>0){
            return true;
        }
        return false;
    }

    //根据机会id删除任务
    @Override
    public boolean deleteUserTaskChId(Long chId) {
        int count=userTaskMapper.deleteUserTaskChId(chId);
        if(count>0){
            return true;
        }
        return false;
    }

    //添加一条任务
    @Override
    public boolean addUserTask(UserTask userTask) {

        int count=userTaskMapper.addUserTask(userTask);
        if(count>0){
            return true;
        }
        return false;
    }

    //修改一条任务信息
    @Override
    public boolean updateUserTask(UserTask userTask) {

        int count=userTaskMapper.updateUserTask(userTask);
        if(count>0){
            return true;
        }
        return false;
    }

    //修改任务的状态
    @Override
    public boolean updateUserTasktaskStatus(Long taskId) {

        int count=userTaskMapper.updateUserTasktaskStatus(taskId);

        if(count>0){
            return true;
        }

        return false;
    }


}
