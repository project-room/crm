package com.crm.biz.user.dao;

import com.crm.entity.CstSchedule;
import com.crm.entity.UserTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
@Component
public interface UserTaskMapper {
    UserTask findById(Long id);

    void deleteById(Long id);

    void updateUserTaskById(UserTask userTask);


    //查询任务表
    List<UserTask> getUserTask(Long chId);

    //删除一条任务
    int deleteUserTask(Long taskId);

    //根据机会id删除记录
    int deleteUserTaskChId(Long chId);

    //添加一条任务
    int  addUserTask(UserTask userTask);

    //修改一条任务
    int  updateUserTask(UserTask userTask);

    //修改任务的状态
    int updateUserTasktaskStatus(Long taskId);
}
