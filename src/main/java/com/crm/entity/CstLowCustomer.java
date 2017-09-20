package com.crm.entity;

/**
 * Created by Administrator on 2017/9/12.
 * 下级客户表
 */
public class CstLowCustomer {
    private Long lowCustId;

    private Long highCustId;

    private String custCompany;

    private Long custId;

    public Long getLowCustId() {
        return lowCustId;
    }

    public void setLowCustId(Long lowCustId) {
        this.lowCustId = lowCustId;
    }

    public Long getHighCustId() {
        return highCustId;
    }

    public void setHighCustId(Long highCustId) {
        this.highCustId = highCustId;
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany == null ? null : custCompany.trim();
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }
}
