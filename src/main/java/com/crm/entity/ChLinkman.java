package com.crm.entity;

public class ChLinkman {
    private Long linkId;

    private String linkName;

    private String linkPhone;

    private String linkLandlinePhone;

    private String linkEmail;

    private String linkQq;

    private String linkWechat;

    private Integer linkStatus;

    private Long chId;

    private String linkDepartment;

    private String linkPosition;

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getLinkLandlinePhone() {
        return linkLandlinePhone;
    }

    public void setLinkLandlinePhone(String linkLandlinePhone) {
        this.linkLandlinePhone = linkLandlinePhone == null ? null : linkLandlinePhone.trim();
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail == null ? null : linkEmail.trim();
    }

    public String getLinkQq() {
        return linkQq;
    }

    public void setLinkQq(String linkQq) {
        this.linkQq = linkQq == null ? null : linkQq.trim();
    }

    public String getLinkWechat() {
        return linkWechat;
    }

    public void setLinkWechat(String linkWechat) {
        this.linkWechat = linkWechat == null ? null : linkWechat.trim();
    }

    public Integer getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
    }

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public String getLinkDepartment() {
        return linkDepartment;
    }

    public void setLinkDepartment(String linkDepartment) {
        this.linkDepartment = linkDepartment == null ? null : linkDepartment.trim();
    }

    public String getLinkPosition() {
        return linkPosition;
    }

    public void setLinkPosition(String linkPosition) {
        this.linkPosition = linkPosition == null ? null : linkPosition.trim();
    }
}