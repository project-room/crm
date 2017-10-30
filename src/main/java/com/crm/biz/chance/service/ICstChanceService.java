package com.crm.biz.chance.service;

import com.crm.common.Page;
import com.crm.entity.CstChance;
import com.crm.entity.CstCustomer;
import com.crm.entity.CstSchedule;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ICstChanceService {

    public Page<CstChance> getCstChance(Long userId, int currentPage, int pageSize);

    public boolean addCstChance(CstChance cstChance);

    public CstChance  getCstChanceId(Long chId);

    public  boolean deleteCstChance(Long id);

    public  boolean updateCstChance(CstChance cstChance);

    public  int getCstChanceCount(Long userId);

    public Page<CstChance> getCstChanceTo(CstChance cstChance, int currentPage, int pageSize);

    public boolean updateChance(CstChance cst);

   public  boolean updateCst(CstChance cstChance);

   public CstCustomer getCstCustomer(long id);

}
