package com.crm.entity;


import java.util.List;

public class CstCustomer {
    private Long custId;

    private String custName;

    private String custPhone;

    private String custEmail;

    private String custCompany;

    private String custAddress;

    private String custIndustry;

    private String custPic;

    private String custSales;

    private Long userId;

    private Integer type;

    private List<CstLabel> labelList;

    private List<CstLowCustomer> lowCustomerList;

    private List<CstRecord> recordList;

    private List<CstSchedule> scheduleList;

    private List<CstChance> chanceList;

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

    public List<CstLowCustomer> getLowCustomerList() {
        return lowCustomerList;
    }

    public void setLowCustomerList(List<CstLowCustomer> lowCustomerList) {
        this.lowCustomerList = lowCustomerList;
    }

    public List<CstLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<CstLabel> labelList) {
        this.labelList = labelList;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany == null ? null : custCompany.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry == null ? null : custIndustry.trim();
    }

    public String getCustPic() {
        return custPic;
    }

    public void setCustPic(String custPic) {
        this.custPic = custPic == null ? null : custPic.trim();
    }

    public String getCustSales() {
        return custSales;
    }

    public void setCustSales(String custSales) {
        this.custSales = custSales == null ? null : custSales.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}