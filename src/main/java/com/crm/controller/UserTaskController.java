package com.crm.controller;

import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.biz.user.dao.UserTaskMapper;
import com.crm.biz.user.service.IUserTaskService;
import com.crm.common.BaseController;
import com.crm.entity.SysUser;
import com.crm.entity.UserTask;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Administrator on 2017/9/14.
 */
@Controller
/*@RestController*/
@RequestMapping("/UserTask")
public class UserTaskController extends BaseController {
    @Autowired
    private UserTaskMapper userTaskMapper;

    @Autowired
    private IUserTaskService iUserTaskService;

    @RequestMapping("selectUserTaskById")
    public Map selectById() {
        Map map =result();
        UserTask userTask = userTaskMapper.findById(1l);
        map.put("userTask", userTask);
        return map;
    }

    //根据机会id查询任务
    @RequestMapping("/getUserTask/{chId}")
    public void getUserTask(HttpServletRequest request, HttpServletResponse response,@PathVariable("chId") Long chId) {
        Map map =result();
        System.out.println(chId);
         try {
             request.setCharacterEncoding("UTF-8");
             response.setCharacterEncoding("UTF-8");
             List<UserTask> userTasksList = iUserTaskService.getUserTask(chId);
             Boolean by = ObjectUtil.isNotNull(userTasksList);
             if (by) {
                 /*map.put("userTasksList", userTasksList);*/
                 map.put("userTasksList",userTasksList);
                 JSONObject jsonObject=JSONObject.fromObject(map);
                 PrintWriter out= response.getWriter();
                 out.print(jsonObject);
             } else {
                 map.put("-1", "查询失败，对象为空");
             }
         }  catch (Exception e) {
             e.printStackTrace();
         }
       /* return map;*/
    }

    //添加一条任务
    @RequestMapping("/addUserTask")
    public Map addUserTask(UserTask userTask) {
        Map map = result();
        try {
            boolean mak = iUserTaskService.addUserTask(userTask);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //删除一条任务
    @RequestMapping("/deleteUserTask")
    public Map deleteUserTask(Long taskId) {
        Map map = result();
         try {
             boolean mak = iUserTaskService.deleteUserTask(taskId);
             if (mak == false) {
                 map.put("code", "-1");
                 map.put("msg", "删除失败");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
        return map;
    }

    //修改任务
    @RequestMapping("/updateUserTask")
    public Map updateUserTask(UserTask userTask) {
        Map map = result();
       try {
           boolean mak = iUserTaskService.updateUserTask(userTask);
           if (mak == false) {
               map.put("code", "-1");
               map.put("msg", "修改失败");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
        return map;
    }

    //修改任务的状态（未完成任务改为已完成）
    @RequestMapping("/updateUserTasktaskStatus")
    public Map updateUserTasktaskStatus(Long taskId) {
        Map map = result();

        try {
            boolean mak = iUserTaskService.updateUserTasktaskStatus(taskId);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "修改失败");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}