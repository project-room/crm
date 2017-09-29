package com.crm.controller;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.common.BaseController;
import com.crm.entity.CstChance;
import com.crm.utils.ObjectUtil;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 * ZHB
 */
@RestController
public class CstChanceController extends BaseController{

    @Autowired
    private ICstChanceService iCstChance;


    //查询我的机会方法
    @RequestMapping("/getCstChance")
    public Map getCstChance(Long userId){
        Map map= TypeUtil.successMap();
        List<CstChance> cstChanceList=iCstChance.getCstChance(userId);
        map.put("cstChanceList",cstChanceList);

        return map;
    }

    //添加方法
    @RequestMapping("/addCstChance")
    public Map addCstChance(CstChance cstChance) {

        Map map= TypeUtil.successMap();

        boolean mak=false;

        mak=iCstChance.addCstChance(cstChance);
        if (mak==true){
            map.put("mak","添加成功");
        }else {
            map.put("mak","添加失败");
        }
        return map;
    }

    //按条件查询
    @RequestMapping("/getCstChanceId")
    public Map getCstChanceId(Long id){
        Map map= TypeUtil.successMap();
        CstChance cstChance=iCstChance.getCstChanceId(id);
        Boolean by= ObjectUtil.isNotNull(cstChance);
        if(by==true){
            map.put("cstChance",cstChance);
        }else {
            map.put("cstChance","查询失败，对象为空");
        }
        return  map;
    }

    //删除方法
    @RequestMapping("/deleteCstChance")
    public Map deleteCstChance(Long id) {
        Map map= TypeUtil.successMap();
        boolean mak=false;

        mak=iCstChance.deleteCstChance(id);

        if (mak==true){
            map.put("mak","删除成功");
        }else {
            map.put("mak","删除失败");
        }
        return map;
    }

    //修改方法
    @RequestMapping("/updateCstChance")
    public  Map updateCstChance(CstChance cstChance) {
        Map map = TypeUtil.successMap();

        boolean  mak = iCstChance.updateCstChance(cstChance);

        if (mak == true) {
            map.put("mak", "修改成功");
        } else {
            map.put("mak", "修改失败");
        }

        return  map;

    }
    //查询有多少条机会信息
    @RequestMapping("/getCstChanceCount")
    public  Map getCstChanceCount(){
        Map map = TypeUtil.successMap();
        int count=iCstChance.getCstChanceCount();
        map.put("count",count);
        return map;
    }

    //根据条件查询
    @RequestMapping("/getCstChanceTo")
    public Map getCstChanceTo(CstChance cstChance){
        Map map=TypeUtil.successMap();

        CstChance Chance=iCstChance.getCstChanceTo(cstChance);
        Boolean by= ObjectUtil.isNotNull(Chance);
        if (by==true){
            map.put("Chance",Chance);
        }else {
            map.put("Chance","查询失败");
        }
        return map;
    }

    //转交客户
    @RequestMapping("/updateChance")
    public  Map updateChance(CstChance cst){
        Map map=TypeUtil.successMap();
        boolean mak=iCstChance.updateChance(cst);
        if (mak==true){
            map.put("mak","修改成功");
        }else{
            map.put("mak","修改失败");
        }
        return  map;
    }

}
