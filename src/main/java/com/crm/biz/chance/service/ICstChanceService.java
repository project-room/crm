package com.crm.biz.chance.service;

import com.crm.common.Page;
import com.crm.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ICstChanceService {

    public Page<CstChance> getCstChance(Long userId, int currentPage, int pageSize);

    public boolean addCstChance(CstChance cstChance,CstCustomer cstCustomer,ChLinkman chLinkman,CstLowCustomer cstLowCustomer,Long linkIdTo,String linkDepartmentTo,String linkPositionTo);

    public   List<CstChance>  getCstChanceId(Long chId);

    public  boolean deleteCstChance(Long id);

    public  boolean updateCstChance(CstChance cstChance,CstCustomer customer,ChLinkman linkman);

    public  int getCstChanceCount(Long userId);

    public Page<CstChance> getCstChanceTo(CstChance cstChance,ChLinkman chLinkman, int currentPage, int pageSize);

    public boolean updateChance(CstChance cst);

    public  List<SysUser>  getSysUser(Long userId);

   public  boolean updateCst(CstChance cstChance);

    public List<CstCustomer>  getCstCustomer(Long id);

    public CstCustomer getCstCustomerCustId(Long custId);

    public  Page<CstChance> getCstChanceUserId(Long userId, int currentPage, int pageSize);

    public boolean  addChance(CstChance cstChance);

    public  Page<CstChance> getfilterChance(CstChance chance,String begindate, String finishdate, int currentPage, int pageSize);

}
