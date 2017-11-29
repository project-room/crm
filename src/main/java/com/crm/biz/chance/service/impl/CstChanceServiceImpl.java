package com.crm.biz.chance.service.impl;

import com.crm.biz.chance.dao.CstChanceMapper;
import com.crm.biz.chance.service.ICstChanceService;
import com.crm.biz.customer.dao.ChLinkmanMapper;
import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.common.Page;
import com.crm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ChLinkmanMapper chLinkmanMapper;

    @Autowired
    private CstLowCustomerMapper cstLowCustomerMapper;

    @Autowired
    private SysUserMapper sysUserMapper;


    //根据用户id查询机会
    @Override
    public Page<CstChance> getCstChance(Long userId,String custCompany,int currentPage, int pageSize) {

        SysUser sysUser=sysUserMapper.selectSysUserAndRoleInfoBySysUserId(userId);
        System.out.println(sysUser.getSysRole().getRoleName()+"角色名称：");
        if(sysUser.getSysRole().getRoleName().equals("销售员")){
            Long count = (long) cstChanceMapper.getCstChanceCount(userId);
            int currentPageLimit = (currentPage - 1) * pageSize;
            List<CstChance> cstChances = cstChanceMapper.getCstChance(userId, custCompany, currentPageLimit, pageSize);
            return new Page<CstChance>(currentPage, pageSize, cstChances, count);
        }else {
            Long count = (long) cstChanceMapper.getCstChanceToCount();
            int currentPageLimit = (currentPage - 1) * pageSize;
            List<CstChance> cstChances = cstChanceMapper.getCstChanceNo(custCompany, currentPageLimit, pageSize);
            return new Page<CstChance>(currentPage, pageSize,cstChances, count);
        }
    }

    //转交的客户查询
    @Override
    public Page<CstChance> getCstChanceUserId(Long userId, int currentPage, int pageSize) {
        System.out.println(userId);
        SysUser sysUser=sysUserMapper.selectSysUserAndRoleInfoBySysUserId(userId);
        if(sysUser.getSysRole().getRoleName().equals("销售员")) {
            Long count = (long) cstChanceMapper.getCstChanceCountTo(userId);
            int currentPageLimit = (currentPage - 1) * pageSize;
            List<CstChance> cstChancesList = cstChanceMapper.getCstChanceUserId(userId, currentPageLimit, pageSize);
            return new Page<CstChance>(currentPage, pageSize, cstChancesList, count);
        }else {
            Long count = (long) cstChanceMapper.getCstChanceZhuanCount();
            int currentPageLimit = (currentPage - 1) * pageSize;
            List<CstChance> cstChancesList = cstChanceMapper.getCstChanceNoUserId(currentPageLimit, pageSize);
            return new Page<CstChance>(currentPage, pageSize, cstChancesList, count);
        }
    }

    //新建按阶段转交机会
    @Override
    public boolean addChance(CstChance cstChance) {
        int count=cstChanceMapper.addChance(cstChance);
        if (count>0){
            return true;
        }
        return false;
    }

    //添加机会
    @Override
    public boolean addCstChance(CstChance cstChance,CstCustomer cstCustomer,ChLinkman chLinkman,CstLowCustomer cstLowCustomer,Long linkIdTo,String linkDepartmentTo,String linkPositionTo){
        int count = cstChanceMapper.addCstChance(cstChance);
        Long chId=cstChance.getChId();
        ChLinkman chLinkmanTo=new ChLinkman();
        chLinkmanTo.setLinkId(linkIdTo);
        chLinkmanTo.setLinkDepartment(linkDepartmentTo);
        chLinkmanTo.setLinkPosition(linkPositionTo);
        chLinkmanTo.setChId(chId);
        cstCustomerMapper.updateCustomer(cstCustomer);
        chLinkman.setChId(chId);
        chLinkmanMapper.updateLinkman(chLinkmanTo);
        System.out.println(chLinkman.getLinkName()+"这个值");
        chLinkmanMapper.addChLinkman(chLinkman);
        cstLowCustomerMapper.addCstLowCust(cstLowCustomer);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //根据机会id查询机会的详细信息
    @Override
    public List<CstChance> getCstChanceId(Long chId) {

        return cstChanceMapper.getCstChanceId(chId);
    }

    //机会新建查询客户
    @Override
    public List<CstCustomer> getCstCustomer(Long id) {

        List<CstCustomer> cstCustomerList=cstCustomerMapper.getCstCustomer(id);

        return cstCustomerList;
    }

    //根据机会id查询客户关联信息
    @Override
    public CstCustomer getCstCustomerCustId(Long custId) {

        CstCustomer cstCustomerList=cstCustomerMapper.getCstCustomerCustId(custId);

        return cstCustomerList;
    }


    //根据机会id删除机会
    @Override
    public boolean deleteCstChance(Long id) {

        int count = cstChanceMapper.deleteCstChance(id);
        chLinkmanMapper.deleteLinkStatus(id);
        chLinkmanMapper.updateChId(id);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //根据机会id修改机会
    @Override
    public boolean updateCstChance(CstChance cstChance,CstCustomer customer,ChLinkman linkman) {

        int count = cstChanceMapper.updateCstChance(cstChance);
        int cou=cstCustomerMapper.updatecstCustomer(customer);
        System.out.println(linkman.getLinkPosition());
        System.out.println(linkman.getLinkId());
        chLinkmanMapper.updateChLinkman(linkman);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //修改机会表用户id
    @Override
    public boolean updateChance(CstChance cst) {
        int count = cstChanceMapper.updateChance(cst);
     /*   int cou = cstCustomerMapper.updateCstCustomer(cst);*/
        if (count > 0 ) {
            return true;
        }
        return false;
    }
    //不通过时修改机会表
    @Override
    public boolean updateChanceTo(Long chId) {
          int count=cstChanceMapper.updateChanceTo(chId);
          if (count>0){

              return true;
          }
        return false;
    }

    //根据机会Id查询客户对应的下级客户
    @Override
    public CstCustomer getCstLowCust(Long chId) {

        return cstCustomerMapper.getCstLowCust(chId);
    }


    //查询用户表的其他用户
    @Override
    public List<SysUser> getSysUser(Long userId) {
        System.out.println(userId+"用户Id");
        return sysUserMapper.getSysUser(userId);
    }

    //根据状态来同时修改机会和客户的负责人
    @Override
    public boolean updateCst(CstChance cstChance) {
        int count=cstChanceMapper.updateCst(cstChance);

       /* int cou=cstCustomerMapper.updateCstCustomer(cstChance);*/

        if (count > 0 /*&& cou > 0*/) {
            return true;
        }
        return false;
    }


    //查询总共有多少条机会
    @Override
    public int getCstChanceCount(Long userId) {

        int count = cstChanceMapper.getCstChanceCount(userId);

        return count;
    }

    //机会的条件查询
    @Override
    public Page<CstChance> getCstChanceTo(CstChance cstChance,ChLinkman chLinkman, int currentPage, int pageSize) {
        Long count = (long) cstChanceMapper.getCstChanceCount(cstChance.getUserId());
        int currentPageLimit = (currentPage - 1) * pageSize;
        List<CstChance> cst = cstChanceMapper.getCstChanceTo(cstChance,chLinkman,currentPageLimit, pageSize);
        return new Page<CstChance>(currentPage, pageSize, cst, count);

    }
    //机会转交的条件查询
    @Override
    public Page<CstChance> getfilterChance(CstChance chance,String begindate,String finishdate, int currentPage, int pageSize) {
        Long count = (long) cstChanceMapper.getCstChanceCountTo(chance.getUserId());
        int currentPageLimit = (currentPage - 1) * pageSize;
        List<CstChance> ChanceList=cstChanceMapper.getfilterChance(chance,begindate,finishdate,currentPageLimit,pageSize);
        return new Page<CstChance>(currentPage, pageSize, ChanceList, count);
    }
}