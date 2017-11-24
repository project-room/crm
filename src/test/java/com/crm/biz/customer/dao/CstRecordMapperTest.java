package com.crm.biz.customer.dao;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.entity.CstChance;
import com.crm.entity.CstRecord;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CstRecordMapperTest {
    @Autowired
    private CstRecordMapper cstRecordMapper;
    @Autowired
    private CstChanceMapper cstChanceMapper;
//    @Test
//    public void getCstRecord(){
//        List<CstRecord> cstRecords= cstRecordMapper.getCstRecord(1L);
//        for (CstRecord cstRecord:cstRecords
//                ) {
//            List<CstChance> cstChances= cstChanceMapper.c(cstRecord.getChId());
//            for (CstChance cstChance:cstChances
//                    ) {
//                System.out.println("cstChance:"+cstChance);
//            }
//        }
//    }
//    @Test
    public void getCstRecord(){
     List<CstChance> cstChances=cstChanceMapper.getCstChanceId(1L);

    }

}