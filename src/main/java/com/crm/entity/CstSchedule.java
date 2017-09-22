package com.crm.entity;

import java.util.Date;

public class CstSchedule {
    private Long scheId;

    private Integer scheType;

    private Date scheTime;

    private String scheContent;

    private Long chId;

    public Long getScheId() {
        return scheId;
    }

    public void setScheId(Long scheId) {
        this.scheId = scheId;
    }

    public Integer getScheType() {
        return scheType;
    }

    public void setScheType(Integer scheType) {
        this.scheType = scheType;
    }

    public Date getScheTime() {
        return scheTime;
    }

    public void setScheTime(Date scheTime) {
        this.scheTime = scheTime;
    }

    public String getScheContent() {
        return scheContent;
    }

    public void setScheContent(String scheContent) {
        this.scheContent = scheContent == null ? null : scheContent.trim();
    }

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }
}