package com.crm.enums;

/**
 * Created by Administrator on 2017/10/16.
 */
public enum CstCustomerTypeEnums {
    GONGHAI_CUSTOMER_TYPE(2,"公海客户"),
    ;
    private Integer code;
    private String message;

    CstCustomerTypeEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
