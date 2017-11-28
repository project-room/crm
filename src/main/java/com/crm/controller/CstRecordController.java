package com.crm.controller;

import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.dao.CstRecordMapper;
import com.crm.biz.customer.service.ICstRecordService;
import com.crm.common.BaseController;
import com.crm.entity.CstLowCustomer;
import com.crm.entity.CstRecord;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
@Controller
/*@RestController*/
@RequestMapping("/CstRecord")
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
       cstRecordMapper.saveCstRecord(cstRecord);
      Long reId= cstRecord.getReId();
      map.put("reId",reId);
        return map;
    }

    //根据机会id查询记录表
    @RequestMapping("/getCstRecord/{id}")
    public  void getCstRecord(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") Long id){
        Map map=result();
        System.out.println(id);
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            List<CstRecord> RecordList = iCstRecordService.getCstRecord(id);
            int count=iCstRecordService.getRecordCount(id);
            System.out.println(count+"记录总条数");
                map.put("RecordList",RecordList);
                JSONObject object=JSONObject.fromObject(map);
                PrintWriter out= response.getWriter();
                out.print(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
      /*  return  map;*/
    }

    //添加一条记录
    @RequestMapping("/addCstRecord")
    public void addCstRecord(HttpServletRequest request, HttpServletResponse response){
        Map map= result();
        Date date = new Date();
        date.getTime();
        CstRecord cstRecord=new CstRecord();
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String reContent=request.getParameter("recordTextareaVal");
            String chId=request.getParameter("chId");
            Long id= Long.parseLong(chId);
            System.out.println(id+"机会Id");
            cstRecord.setChId(id);
            System.out.println(reContent+"记录");
            cstRecord.setReContent(reContent);
            cstRecord.setReDate(date);
            boolean mak = iCstRecordService.addCstRecord(cstRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
