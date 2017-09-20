package com.crm.biz.chance.service.impl;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.entity.CstChance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstChanceServiceImpl implements ICstChanceService {

    @Autowired
    private CstChanceMapper cstChanceMapper;

    public List<CstChance> findChanceById(Long CstId){
        return cstChanceMapper.selectListChByCstId(CstId);
    }


}
