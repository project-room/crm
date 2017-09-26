package com.crm.biz.chance.dao;

/**
 * Created by Administrator on 2017/9/12.
 */
import com.crm.entity.CstChance;

import java.util.List;

import com.crm.entity.CstCustomer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CstChanceMapper {

    CstChance findById(Long id);

    void addCstCustomer(CstChance cstChance);

    void deleteById(Long id);

    void updateCstChanceById(CstChance cstChance);

    //根据用户id查询机会
     List<CstChance> getCstChance(Long userId);

    //添加机会
    int addCstChance(CstChance cstChance);

    //根据机会id查询机会的详细信息
    CstChance getCstChanceId(Long chId);

    //根据机会id删除机会
    int deleteCstChance(Long id);

    //根据机会id修改机会
    int updateCstChance(CstChance cstChance);

    //根据机会id修改机会表的用户id
    int updateChance(CstChance cst);

    //根据机会对象里的客户id修改客户表里的用户id
    int updateCstCustomer(CstChance cs);

    //查询总共有多少条机会
    int  getCstChanceCount();

    //机会的条件查询
    CstChance getCstChanceTo(CstChance cstChance);


}