package com.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class  CstCustomer {
    private Long custId;    //客户id

    private String custEmail;  //邮箱

    private String custCompany;   //客户名称

    private String custAddress;    //客户地址

    private String custprovinceChar; //所在省份

    private String custIndustry;      //客户行业

    private String custPic;       //图片地址

    private String custSales;      //销售渠道

    private Long userId;       //用户id

    private Integer custClassify;   //类型

    private String custContent;     //客户详细信息

    private String custLifecycle;    //生命周期

    private String custWebsite;      //官网

    private String custType;        //分类

    private Date custDate;

    private String custCustomerNature; //客户性质

    private  String  custCustomerBudget;//客户预算

    //时期为字符串格式
    private String revertDate;

    //用户id转换成用户名格式
    private String revertUserNameFromId;

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

    public String getRevertUserNameFromId() {
        return revertUserNameFromId;
    }

    public void setRevertUserNameFromId(String revertUserNameFromId) {
        this.revertUserNameFromId = revertUserNameFromId;
    }

    public String getCustCustomerNature() {
        return custCustomerNature;
    }

    public void setCustCustomerNature(String custCustomerNature) {
        this.custCustomerNature = custCustomerNature;
    }

    public String getCustCustomerBudget() {
        return custCustomerBudget;
    }

    public void setCustCustomerBudget(String custCustomerBudget) {
        this.custCustomerBudget = custCustomerBudget;
    }

    public String getCustprovinceChar() {
        return custprovinceChar;
    }

    public void setCustprovinceChar(String custprovinceChar) {
        this.custprovinceChar = custprovinceChar;
    }
}