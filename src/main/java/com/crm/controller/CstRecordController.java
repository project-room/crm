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
//    Long id
    @RequestMapping("/getCstRecord")
    public  Map getCstRecord(){
        Map map= TypeUtil.successMap();
        //测试数据
        Long id=1L;

        List<CstRecord> RecordList=iCstRecordService.getCstRecord(id);
        Boolean by= ObjectUtil.isNotNull(RecordList);
        if(by==true){
            map.put("RecordList",RecordList);
        }else {
            map.put("RecordList","查询失败，对象为空");
        }
        return  map;
    }
    //添加一条记录
    @RequestMapping("/addCstRecord")
    public Map addCstRecord(CstRecord cstRecord){
        Map map= TypeUtil.successMap();
        boolean mak=false;
        mak=iCstRecordService.addCstRecord(cstRecord);
        if (mak==true){
            map.put("mak","添加成功");
        }else {
            map.put("mak","添加失败");
        }
        return map;
    }

     //删除记录
    @RequestMapping("/deleteCstRecord")
    public Map deleteCstRecord(Long  reId){
        Map map= TypeUtil.successMap();
        boolean mak=false;

        mak=iCstRecordService.deleteCstRecord(reId);
        if (mak==true){
            map.put("mak","删除成功");
        }else {
            map.put("mak","删除失败");
        }
        return map;
    }

    //修改记录
    @RequestMapping("/updateCstRecord")
    public Map updateCstRecord( CstRecord Record){
        Map map= TypeUtil.successMap();
        boolean mak=false;
        mak=iCstRecordService.updateCstRecord(Record);
        if (mak==true){
            map.put("mak","修改成功");
        }else {
            map.put("mak","修改失败");
        }
        return map;
    }

}
