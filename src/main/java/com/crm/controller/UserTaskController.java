package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.user.dao.UserTaskMapper;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.entity.SysUser;
import com.crm.entity.UserTask;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class UserTaskController {
    @Autowired
    private UserTaskMapper userTaskMapper;

    @Autowired
    private IUserTaskService iUserTaskService;

    @RequestMapping("selectUserTaskById")
    public Map selectById() {
        Map map = TypeUtil.successMap();
        UserTask userTask = userTaskMapper.findById(1l);
        map.put("userTask", userTask);
        return map;
    }

    //根据机会id查询任务
    @RequestMapping("/getUserTask")
    public Map getUserTask(Long chId) {
        Map map = TypeUtil.successMap();
        List<UserTask> userTasksList = iUserTaskService.getUserTask(chId);
        Boolean by = ObjectUtil.isNotNull(userTasksList);
        if (by == true) {
            map.put("userTasksList", userTasksList);
        } else {
            map.put("userTasksList", "查询失败，对象为空");
        }
        return map;
    }

    //添加一条任务
    @RequestMapping("/addUserTask")
    public Map addUserTask(UserTask userTask) {
        Map map = TypeUtil.successMap();
        boolean mak = false;
        mak = iUserTaskService.addUserTask(userTask);
        if (mak == true) {
            map.put("mak", "添加成功");
        } else {
            map.put("mak", "添加失败");
        }
        return map;
    }

    //删除一条任务
    @RequestMapping("/deleteUserTask")
    public Map deleteUserTask(Long taskId) {
        Map map = TypeUtil.successMap();
        boolean mak = false;
        mak = iUserTaskService.deleteUserTask(taskId);
        if (mak == true) {
            map.put("mak", "删除成功");
        } else {
            map.put("mak", "删除失败");
        }
        return map;
    }

    //修改任务
    @RequestMapping("/updateUserTask")
    public Map updateUserTask(UserTask userTask) {
        Map map = TypeUtil.successMap();
        boolean mak = false;
        mak = iUserTaskService.updateUserTask(userTask);
        if (mak == true) {
            map.put("mak", "修改成功");
        } else {
            map.put("mak", "修改失败");
        }
        return map;
    }

    //修改任务的状态（未完成任务改为已完成）
    @RequestMapping("/updateUserTasktaskStatus")
    public Map updateUserTasktaskStatus(Long taskId) {
        Map map = TypeUtil.successMap();
        boolean mak = false;
        mak = iUserTaskService.updateUserTasktaskStatus(taskId);

        if (mak == true) {
            map.put("mak", "修改状态成功");
        } else {
            map.put("mak", "修改状态失败");
        }
        return map;
    }
}