package com.crm.biz.user.dao;

import com.crm.entity.UserTask;
import com.crm.entity.UserTaskExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
@Component
public interface UserTaskMapper {
    int countByExample(UserTaskExample example);

    int deleteByExample(UserTaskExample example);

    int deleteByPrimaryKey(Long taskId);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    List<UserTask> selectByExample(UserTaskExample example);

    UserTask selectByPrimaryKey(Long taskId);

    int updateByExampleSelective(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByExample(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);
}
