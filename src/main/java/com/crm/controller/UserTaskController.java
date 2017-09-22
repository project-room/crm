package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.user.dao.UserTaskMapper;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.entity.SysUser;
import com.crm.entity.UserTask;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 */
@RestController
public class UserTaskController {
    @Autowired
    private UserTaskMapper userTaskMapper;
    @RequestMapping("selectUserTaskById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        UserTask userTask=userTaskMapper.findById(1l);
        map.put("userTask",userTask);
        return map;
    }
}
