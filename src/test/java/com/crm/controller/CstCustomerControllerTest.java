/*
package com.crm.controller;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

*/
/**
 * Created by Administrator on 2017/11/2.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class CstCustomerControllerTest {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void redisTest(HttpServletResponse response){
        redisTemplate.opsForValue().set("bibi","mama",5, TimeUnit.SECONDS);
        redisTemplate.opsForValue().getOperations().delete("bibi");
        Cookie cookie=new Cookie("name","value");
        cookie.setMaxAge(7200);
        cookie.setPath("/");
        response.addCookie(cookie);


    }

    @Test
    public void alidayuTest() throws ApiException {
        String url="";
        String appkey="";
        String secret="";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("阿里大于");
        req.setSmsParamString("{\"code\":\"1234\",\"product\":\"alidayu\"}");
        req.setRecNum("13000000000");
        req.setSmsTemplateCode("SMS_585014");
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}*/
