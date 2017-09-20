package com.crm.controller;

import com.crm.biz.user.service.IUserTaskService;
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
    private IUserTaskService userTaskService;

    @RequestMapping("/addUserTask")
    public Map addUserTask(UserTask userTask){
        Map map= TypeUtil.successMap();
        userTaskService.addUserTask(userTask);
        return map;
    }

//    public Map selectAllUserTask(){
//        Map map= TypeUtil.successMap();
//
//    }


}
