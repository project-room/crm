package com.crm.entity;

import com.crm.common.BaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 * 首页动态表
 */
public class SysDynamic extends BaseEntity{
    private Long dyId;

    private Long userId;

    private String userName;

    private String dyContent;

    private Date dyDate;

    private Integer dyClassify;

    private Long dyClassifyId;

    public Long getDyId() {
        return dyId;
    }

    public void setDyId(Long dyId) {
        this.dyId = dyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDyContent() {
        return dyContent;
    }

    public void setDyContent(String dyContent) {
        this.dyContent = dyContent == null ? null : dyContent.trim();
    }

    public Date getDyDate() {
        return dyDate;
    }

    public void setDyDate(Date dyDate) {
        this.dyDate = dyDate;
    }

    public Integer getDyClassify() {
        return dyClassify;
    }

    public void setDyClassify(Integer dyClassify) {
        this.dyClassify = dyClassify;
    }

    public Long getDyClassifyId() {
        return dyClassifyId;
    }

    public void setDyClassifyId(Long dyClassifyId) {
        this.dyClassifyId = dyClassifyId;
    }
}
