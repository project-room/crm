package com.crm.biz.customer.service.impl;

import com.crm.entity.CstCustomer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CstCustomerServiceImplTest {

    @Autowired
    private CstCustomerServiceImpl cstCustomerService;
    @Test
    public void selectCstCustomerByName() throws Exception {
      List<CstCustomer> cstCustomers= cstCustomerService.selectCstCustomerByName("公司",2,2);
        for (CstCustomer cstCustomer:cstCustomers
             ) {
            System.out.println("id:"+cstCustomer.getCustId());
        }
        Assert.assertNotNull(cstCustomers);
    }

    @Test
    public void selectCountByCstCustomerName() throws Exception {
       Long count= cstCustomerService.selectCountByCstCustomerName("公司");
        System.out.println("count:"+count);
    }

    @Test
    public void regex(){
        String number="73643346hfsf386";
        Boolean num=isNumeric(number);
        System.out.println("num:"+num);
    }

     /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

}