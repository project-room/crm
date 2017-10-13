package com.crm.dto;


import com.crm.entity.ChLinkman;
import com.crm.entity.CstLabel;
import com.crm.entity.CstLowCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public class CstCustomerDto {
    private Long custId;

    private String custEmail;

    private String custCompany;

    private String custAddress;

    private String custIndustry;

    private String custPic;

    private String custSales;

    private Long userId;

    private Integer custClassify;

    private String custContent;

    private String custLifecycle;

    private String custWebsite;

    private String custType;

    private Date custDate;

    //时期为字符串格式
    private String revertDate;

    private List<CstLabel> labelList;

    private List<CstLowCustomer>  lowCustomerList;

    private List<ChLinkman> linkmanList;

    public List<ChLinkman> getLinkmanList() {
        return linkmanList;
    }

    public Date getCustDate() {
        return custDate;
    }

    public void setCustDate(Date custDate) {
        this.custDate = custDate;
    }

    public void setLinkmanList(List<ChLinkman> linkmanList) {
        this.linkmanList = linkmanList;
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

    public Integer getCustClassify() {
        return custClassify;
    }

    public void setCustClassify(Integer custClassify) {
        this.custClassify = custClassify;
    }

    public String getCustContent() {
        return custContent;
    }

    public void setCustContent(String custContent) {
        this.custContent = custContent == null ? null : custContent.trim();
    }

    public String getCustLifecycle() {
        return custLifecycle;
    }

    public void setCustLifecycle(String custLifecycle) {
        this.custLifecycle = custLifecycle == null ? null : custLifecycle.trim();
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite == null ? null : custWebsite.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getRevertDate() {
        return revertDate;
    }

    public void setRevertDate(String revertDate) {
        this.revertDate = revertDate;
    }

}
