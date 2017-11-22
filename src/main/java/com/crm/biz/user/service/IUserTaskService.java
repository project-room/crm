package com.crm.biz.user.service;

import com.crm.entity.UserTask;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public interface IUserTaskService {

     public List<UserTask> getUserTask(Long chId);

     public boolean deleteUserTask(Long taskId);

     public boolean addUserTask(UserTask userTask);

     public boolean  updateUserTask(UserTask userTask);

      public boolean updateUserTasktaskStatus(Long taskId);

      public  boolean deleteUserTaskChId(Long chId);

}
