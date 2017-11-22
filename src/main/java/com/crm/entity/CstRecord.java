package com.crm.entity;

import java.util.Date;
import java.util.List;

public class CstRecord {
    private Long reId;

    private String reContent;

    private Long chId;

    private Date reDate;

    private List<SysAttachment> attachmentList;

    private CstChance chance;

    public List<SysAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<SysAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public Long getReId() {
        return reId;
    }

    public void setReId(Long reId) {
        this.reId = reId;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent == null ? null : reContent.trim();
    }

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }


    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public CstChance getChance() {
        return chance;
    }

    public void setChance(CstChance chance) {
        this.chance = chance;
    }
}