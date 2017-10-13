package com.crm.enums;

/**
 * Created by Administrator on 2017/10/13.
 */
public enum ChLinkmanStatusEnums {
    MASTER_CHLINKMAN(0,"主联系人"),
    ;
    private Integer code;
    private String message;

    ChLinkmanStatusEnums(Integer code, String message) {
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
