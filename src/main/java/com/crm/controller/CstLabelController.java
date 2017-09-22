package com.crm.controller;

import com.crm.biz.customer.dao.CstLabelMapper;
import com.crm.common.BaseController;
import com.crm.entity.CstLabel;
import com.crm.utils.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class CstLabelController extends BaseController{
    @Autowired
    private CstLabelMapper cstLabelMapper;
    @RequestMapping("selectCstLabelById")
    public Map selectCstLabelById(){
        Map map= TypeUtil.successMap();
       CstLabel cstLabel= cstLabelMapper.findById(1l);
       map.put("cstLabel",cstLabel);
        return map;
    }
}
