package com.crm.dto;

/**
 * 分页和筛选的参数
 * Created by Administrator on 2017/11/20.
 */
// getData.customName = $('#name').val();
//         getData.customContact = $('#contact').val();
//         getData.customMobile = $('#mobile').val();
//         getData.customTelephone = $('#telphone').val();
//         getData.customRenlingren = $('#renlingren').val();
//         getData.customMail = $('#mail').val();
//         getData.customDay = $('#day').val();
//         getData.customHour = $('#hour').val();
public class DataConditionDto {
    private String customContact;
    private String customMobile;
    private String customTelephone;
    private String customRenlingren;
    private String customMail;
    private String customDay;
    private String customHour;

    public String getCustomContact() {
        return customContact;
    }

    public void setCustomContact(String customContact) {
        this.customContact = customContact;
    }

    public String getCustomMobile() {
        return customMobile;
    }

    public void setCustomMobile(String customMobile) {
        this.customMobile = customMobile;
    }

    public String getCustomTelephone() {
        return customTelephone;
    }

    public void setCustomTelephone(String customTelephone) {
        this.customTelephone = customTelephone;
    }

    public String getCustomRenlingren() {
        return customRenlingren;
    }

    public void setCustomRenlingren(String customRenlingren) {
        this.customRenlingren = customRenlingren;
    }

    public String getCustomMail() {
        return customMail;
    }

    public void setCustomMail(String customMail) {
        this.customMail = customMail;
    }

    public String getCustomDay() {
        return customDay;
    }

    public void setCustomDay(String customDay) {
        this.customDay = customDay;
    }

    public String getCustomHour() {
        return customHour;
    }

    public void setCustomHour(String customHour) {
        this.customHour = customHour;
    }
}
