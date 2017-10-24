package com.crm.controller;

import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.common.BaseController;
import com.crm.entity.CstLowCustomer;
import com.crm.entity.CstRecord;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class CstRecordController extends BaseController{
    @Autowired
    private CstRecordMapper cstRecordMapper;

    @Autowired
    private  ICstRecordService iCstRecordService;

    @RequestMapping("selectCstRecordById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstRecord cstRecord=cstRecordMapper.findById(1l);
        map.put("cstRecord",cstRecord);
        return map;
    }

    @RequestMapping("selectCstRecord")
    public Map selectCstRecord(){
        Map map=TypeUtil.successMap();
        CstRecord cstRecord=new CstRecord();
        cstRecord.setReContent("内容");
        cstRecord.setChId(4l);
        cstRecord.setUserName("李四");
       cstRecordMapper.saveCstRecord(cstRecord);
      Long reId= cstRecord.getReId();
      map.put("reId",reId);
        return map;
    }

    //根据机会id查询记录表
    @RequestMapping("/getCstRecord")
    public  Map getCstRecord(Long id){
        Map map=result();
        try {
            List<CstRecord> RecordList = iCstRecordService.getCstRecord(id);
            Boolean by = ObjectUtil.isNotNull(RecordList);
            if (by) {
                map.put("RecordList", RecordList);
            } else {
                map.put("-1", "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  map;
    }
    //添加一条记录
    @RequestMapping("/addCstRecord")
    public Map addCstRecord(CstRecord cstRecord){
        Map map= result();
        try {
            boolean mak = iCstRecordService.addCstRecord(cstRecord);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

     //删除记录
    @RequestMapping("/deleteCstRecord")
    public Map deleteCstRecord(Long  reId){
        Map map= result();
      try{
           boolean mak=iCstRecordService.deleteCstRecord(reId);
           if (mak == false) {
            map.put("code", "-1");
            map.put("msg", "删除失败");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return map;
    }

    //修改记录
    @RequestMapping("/updateCstRecord")
    public Map updateCstRecord( CstRecord Record){
        Map map= result();
        try {
            boolean mak = iCstRecordService.updateCstRecord(Record);
            if (mak == false) {
                map.put("code", "-1");
                map.put("msg", "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
