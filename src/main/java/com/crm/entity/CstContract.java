package com.crm.entity;

import java.util.Date;
import java.util.List;

public class CstContract {
    private Long contractId;

    private String contractType;

    private String contractName;

    private Double contractAllMoney;

    private Long chId;

    private Date signDate;

    private Date expireDate;

    private Integer contractState;

    private String userName;

    private Date createDate;

    private List<SysAttachment> attachmentList;

    public List<SysAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<SysAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public Double getContractAllMoney() {
        return contractAllMoney;
    }

    public void setContractAllMoney(Double contractAllMoney) {
        this.contractAllMoney = contractAllMoney;
    }

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getContractState() {
        return contractState;
    }

    public void setContractState(Integer contractState) {
        this.contractState = contractState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}