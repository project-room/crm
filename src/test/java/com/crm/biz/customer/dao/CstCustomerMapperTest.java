package com.crm.biz.customer.dao;

import com.crm.entity.CstCustomer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CstCustomerMapperTest {
    @Autowired
    private CstCustomerMapper cstCustomerMapper;
    @Test
    public void findById() throws Exception {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String str = sdf.format(new Date());
        System.out.println(str);
    }

    @Test
    public void updateCstCustomerWithId(){
        CstCustomer cstCustomer=new CstCustomer();
        cstCustomer.setCustType("2");
        cstCustomer.setCustDate(new Date(System.currentTimeMillis()));
        cstCustomer.setCustCompany("中华公司");
        cstCustomer.setUserId(1L);
        cstCustomer.setCustAddress("中山路");
        cstCustomerMapper.updateCstCustomerWithId(17L,cstCustomer);
    }

}