package com.crm.entity;

import com.crm.common.BaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 * 任务表
 */
public class UserTask {
    private Long taskId;

    private Integer taskStatus;

    private String taskContent;

    private Date taskDate;

    private Long userId;

    private Long cstId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCstId() {
        return cstId;
    }

    public void setCstId(Long cstId) {
        this.cstId = cstId;
    }
}
