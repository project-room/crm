package com.crm.entity;

import java.util.Date;


public class SysDynamic {
    private Long dyId;       //动态id

    private Long userId;       //用户id

    private String userName;     //用户名称

    private String dyContent;      //动态内容

    private Date dyDate;             //创建时间

    private Integer dyClassify;       //分类

    private Long dyClassifyId;          //分类详细id


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