package com.crm.entity;

import java.util.List;

public class CstLabel {
    private Integer labelId;

    private String labelName;

    private Long userId;

    private List<CstCustomer> customerList;

    public List<CstCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CstCustomer> customerList) {
        this.customerList = customerList;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}