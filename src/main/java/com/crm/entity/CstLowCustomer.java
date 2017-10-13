package com.crm.entity;

public class CstLowCustomer {
    private Long lowId;

    private Long highId;

    private String custLowCompany;

    private Long custLowId;

    public Long getLowId() {
        return lowId;
    }

    public void setLowId(Long lowId) {
        this.lowId = lowId;
    }

    public Long getHighId() {
        return highId;
    }

    public void setHighId(Long highId) {
        this.highId = highId;
    }

    public String getCustLowCompany() {
        return custLowCompany;
    }

    public void setCustLowCompany(String custLowCompany) {
        this.custLowCompany = custLowCompany == null ? null : custLowCompany.trim();
    }

    public Long getCustLowId() {
        return custLowId;
    }

    public void setCustLowId(Long custLowId) {
        this.custLowId = custLowId;
    }
}