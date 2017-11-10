package com.crm.biz.customer.dao;

import com.crm.entity.ChLinkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChLinkmanMapperTest {
    @Autowired
    private ChLinkmanMapper chLinkmanMapper;
    @Test
    public void updateChLinkmanWithIdAndChLinkman() throws Exception {
        ChLinkman chLinkman=new ChLinkman();
        chLinkman.setLinkName("花花");
        chLinkman.setLinkEmail("837462648@qq.com");
        chLinkman.setLinkPhone("13456789977");
        chLinkman.setLinkLandlinePhone("9999999");
        chLinkman.setCustId(1l);
        chLinkman.setLinkStatus(0);
        chLinkmanMapper.updateChLinkmanWithIdAndChLinkman(8L,chLinkman);
    }

}