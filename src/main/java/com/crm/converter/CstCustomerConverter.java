package com.crm.converter;

import com.crm.entity.CstCustomer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/13.
 */
public class CstCustomerConverter {
    public static void dateConvertor(CstCustomer cstCustomer){
        Date formation= cstCustomer.getCustDate();
        String afterDate= new SimpleDateFormat("yyyy-MM-dd hh：mm").format(formation).toString();
        cstCustomer.setRevertDate(afterDate);
    }
}
