package com.crm.entity;

public class SysAttachment {
    private Long attaId;

    private Integer attaClassify;

    private Long attaClassifyId;

    private String attaName;

    private String attaAddress;

    public Long getAttaId() {
        return attaId;
    }

    public void setAttaId(Long attaId) {
        this.attaId = attaId;
    }

    public Integer getAttaClassify() {
        return attaClassify;
    }

    public void setAttaClassify(Integer attaClassify) {
        this.attaClassify = attaClassify;
    }

    public Long getAttaClassifyId() {
        return attaClassifyId;
    }

    public void setAttaClassifyId(Long attaClassifyId) {
        this.attaClassifyId = attaClassifyId;
    }

    public String getAttaName() {
        return attaName;
    }

    public void setAttaName(String attaName) {
        this.attaName = attaName == null ? null : attaName.trim();
    }

    public String getAttaAddress() {
        return attaAddress;
    }

    public void setAttaAddress(String attaAddress) {
        this.attaAddress = attaAddress == null ? null : attaAddress.trim();
    }
}