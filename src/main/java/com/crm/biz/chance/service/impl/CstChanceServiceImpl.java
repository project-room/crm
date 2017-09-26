package com.crm.biz.chance.service.impl;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.biz.customer.dao.CstCustomerMapper;
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

    @Autowired
    private CstCustomerMapper cstCustomerMapper;

    //根据用户id查询机会
    @Override
    public List<CstChance> getCstChance(Long userId){

        return  cstChanceMapper.getCstChance(userId);
    }

    //添加机会
    @Override
    public boolean addCstChance(CstChance cstChance) {
        int count=cstChanceMapper.addCstChance(cstChance);
        if (count > 0) {
            return true;
    }
        return false;
    }

    //根据机会id查询机会的详细信息
    @Override
    public CstChance getCstChanceId(Long chId) {

        return cstChanceMapper.getCstChanceId(chId);
    }

    //根据机会id删除机会
    @Override
    public boolean deleteCstChance(Long id) {

        int count=cstChanceMapper.deleteCstChance(id);

        if(count>0){
            return  true;
        }
        return false;
    }

    //根据机会id修改机会
    @Override
    public boolean updateCstChance(CstChance cstChance) {

        int count=cstChanceMapper.updateCstChance(cstChance);

        if (count>0){
            return true;
        }
        return false;
    }

    //同时修改机会表和客户表里的用户id
    @Override
    public boolean updateChance(CstChance cst) {
         int count=cstChanceMapper.updateChance(cst);
         int cou=cstChanceMapper.updateCstCustomer(cst);
         if (count >0 && cou >0){
             return  true;
         }
        return false;
    }

    //查询总共有多少条机会
    @Override
    public int getCstChanceCount() {

        int count=cstChanceMapper.getCstChanceCount();

        return count;
    }

    //机会的条件查询
    @Override
    public CstChance getCstChanceTo(CstChance cstChance) {

        return cstChanceMapper.getCstChanceTo(cstChance);
    }

}
