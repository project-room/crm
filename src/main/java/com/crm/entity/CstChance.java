package com.crm.entity;

import java.util.Date;

public class CstChance {
    private Long chId;

    private String chContent;

    private Integer chStage;

    private Long custId;

    private Date chDate;

    private Double chMoney;

    private String userName;

    private Long userId;

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public String getChContent() {
        return chContent;
    }

    public void setChContent(String chContent) {
        this.chContent = chContent == null ? null : chContent.trim();
    }

    public Integer getChStage() {
        return chStage;
    }

    public void setChStage(Integer chStage) {
        this.chStage = chStage;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Date getChDate() {
        return chDate;
    }

    public void setChDate(Date chDate) {
        this.chDate = chDate;
    }

    public Double getChMoney() {
        return chMoney;
    }

    public void setChMoney(Double chMoney) {
        this.chMoney = chMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}