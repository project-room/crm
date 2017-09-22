package com.crm.controller;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.common.BaseController;
import com.crm.entity.CstChance;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 * ZHB
 */
@RestController
public class CstChanceController extends BaseController{
    @Autowired
    private CstChanceMapper cstChanceMapper;
    @RequestMapping("selectById")
    public Map selectById(){
        Map map= TypeUtil.successMap();
        CstChance cstChance=cstChanceMapper.findById(1l);
        map.put("cstChance",cstChance);
        return map;
    }
}
