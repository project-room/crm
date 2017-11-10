package com.crm.entity;

import java.util.Date;
import java.util.List;

public class CstChance {
    private Long chId;     //机会id

    private String chContent;   //机会简述

    private Long custId;     //客户id

    private Date chDate;     //创建时间

    private Double chMoney;    //合同金额

    private Long userToId;   //新用户id

    private Long userId;      //用户id

     private String chDept;     //使用部门

    private Integer chDoc;        //是否有需求文档

    private Integer chSupplier;    //是否了解供应商

    private String chUptime;      //期望上线时间

    private String chBackground;   //立项背景

    private  String chIntentionality;  //意向度

    private String chStage;    //阶段

    private  String chImportance; //重要性

    private  String  requirement;  //产品需求

    private String chFollow ;//  跟进结果

    private String chTransaction;//成交年份

    private  String chLostSingleType;//丢单类型

    private  String chReasonsForLosingOrders;//丢单原因

    private  String chStatus;   //状态

    private  Date TransferTime;//机会转交创建时间

    private  Long chExamine;//机会转交审批人

    private List<CstRecord> recordList;

    private List<CstSchedule> scheduleList;

    private List<CstContract> contractList;

    private List<ChLinkman> linkmanList;

    private CstCustomer chCustomer;

    private SysUser sysUser;

    public CstCustomer getChCustomer() {
        return chCustomer;
    }

    public void setChCustomer(CstCustomer chCustomer) {
        this.chCustomer = chCustomer;
    }

    public List<ChLinkman> getLinkmanList() {
        return linkmanList;
    }

    public void setLinkmanList(List<ChLinkman> linkmanList) {
        this.linkmanList = linkmanList;
    }

    public List<CstContract> getContractList() {
        return contractList;
    }

    public void setContractList(List<CstContract> contractList) {
        this.contractList = contractList;
    }

    public List<CstSchedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<CstSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<CstRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<CstRecord> recordList) {
        this.recordList = recordList;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChDept() {
        return chDept;
    }

    public void setChDept(String chDept) {
        this.chDept = chDept == null ? null : chDept.trim();
    }

    public Integer getChDoc() {
        return chDoc;
    }

    public void setChDoc(Integer chDoc) {
        this.chDoc = chDoc;
    }

    public Integer getChSupplier() {
        return chSupplier;
    }

    public void setChSupplier(Integer chSupplier) {
        this.chSupplier = chSupplier;
    }

    public String getChUptime() {
        return chUptime;
    }

    public void setChUptime(String chUptime) {
        this.chUptime = chUptime == null ? null : chUptime.trim();
    }

    public String getChBackground() {
        return chBackground;
    }

    public void setChBackground(String chBackground) {
        this.chBackground = chBackground == null ? null : chBackground.trim();
    }

    public String getChStage() {
        return chStage;
    }

    public void setChStage(String chStage) {
        this.chStage = chStage == null ? null : chStage.trim();
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getChIntentionality() {
        return chIntentionality;
    }

    public void setChIntentionality(String chIntentionality) {
        this.chIntentionality = chIntentionality;
    }

    public String getChImportance() {
        return chImportance;
    }

    public void setChImportance(String chImportance) {
        this.chImportance = chImportance;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getChFollow() {
        return chFollow;
    }

    public void setChFollow(String chFollow) {
        this.chFollow = chFollow;
    }

    public String getChTransaction() {
        return chTransaction;
    }

    public void setChTransaction(String chTransaction) {
        this.chTransaction = chTransaction;
    }

    public String getChLostSingleType() {
        return chLostSingleType;
    }

    public void setChLostSingleType(String chLostSingleType) {
        this.chLostSingleType = chLostSingleType;
    }

    public String getChReasonsForLosingOrders() {
        return chReasonsForLosingOrders;
    }

    public void setChReasonsForLosingOrders(String chReasonsForLosingOrders) {
        this.chReasonsForLosingOrders = chReasonsForLosingOrders;
    }

    public Long getUserToId() {
        return userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }

    public String getChStatus() {
        return chStatus;
    }

    public void setChStatus(String chStatus) {
        this.chStatus = chStatus;
    }

    public Date getTransferTime() {
        return TransferTime;
    }

    public void setTransferTime(Date transferTime) {
        TransferTime = transferTime;
    }

    public Long getChExamine() {
        return chExamine;
    }

    public void setChExamine(Long chExamine) {
        this.chExamine = chExamine;
    }
}