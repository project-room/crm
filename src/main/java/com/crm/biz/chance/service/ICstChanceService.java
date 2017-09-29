package com.crm.biz.chance.service;

import com.crm.entity.CstChance;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ICstChanceService {


    public List<CstChance> getCstChance(Long userId);

    public boolean addCstChance(CstChance cstChance);

    public CstChance  getCstChanceId(Long id);

    public  boolean deleteCstChance(Long id);

    public  boolean updateCstChance(CstChance cstChance);

    public  int getCstChanceCount();

    public CstChance getCstChanceTo(CstChance cstChance);

    public boolean updateChance(CstChance cst);

}
