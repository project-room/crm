package com.crm.biz.user.dao;

import com.crm.entity.CstSchedule;
import com.crm.entity.UserTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
@Component
public interface UserTaskMapper {
    UserTask findById(Long id);

    void addUserTask(UserTask userTask);

    void deleteById(Long id);

    void updateUserTaskById(UserTask userTask);
}
