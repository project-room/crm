package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.ChLinkmanMapper;
import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.dao.CstLabelMapper;
import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.common.Page;
import com.crm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class CstCustomerServiceImpl implements ICstCustomerService{
    @Autowired
    private CstCustomerMapper cstCustomerMapper;
    @Autowired
    private ChLinkmanMapper chLinkmanMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CstLowCustomerMapper cstLowCustomerMapper;
    @Autowired
    private CstLabelMapper cstLabelMapper;
    @Override
    public void cliamCstCustomer(CstCustomer cstCustomer, ChLinkman chLinkman) {

        cstCustomerMapper.saveCstCustomer(cstCustomer);
        //插入客户信息返回客户id
        Long custId=cstCustomer.getCustId();
        chLinkman.setCustId(custId);
        chLinkmanMapper.saveChLinkman(chLinkman);

    }

    @Override
    public Page<CstCustomer> getCstCustomerOnePageInfo(int currentPage, int pageSize) {
        Long count=cstCustomerMapper.getCstCustomerCount();
       int currentPageLimit=currentPage-1;
       List<CstCustomer> cstCustomers= cstCustomerMapper.getPageCstCustomerInfo(currentPageLimit,pageSize);
        return new Page<CstCustomer>(currentPage,pageSize,cstCustomers,count);
    }

    @Override
    public CstCustomer lookCstCustomerInfo(Long cstCustomerId) {
     CstCustomer reCstCustomer=  cstCustomerMapper.selectCstCustomerInfo(cstCustomerId);
        return reCstCustomer;
    }

    @Override
    public List<CstCustomer> selectCstCustomerByName(String custCompany) {
        custCompany="%"+custCompany+"%";
     List<CstCustomer>  cstCustomers= cstCustomerMapper.selectCstCustomerByName(custCompany);
        return cstCustomers;
    }

    @Override
    public List<CstCustomer> selectAllCstCutomer() {
        return cstCustomerMapper.selectAllCstCutomer();
    }

    @Override
    public void deleteCstCustomerById(Long id) {
        cstCustomerMapper.deleteCstCustomerAndChLinkmanById(id);
    }

    @Override
    public void editCstCustomerInfo(Long cstCustId,Long userId,CstCustomer cstCustomer,CstLowCustomer cstLowCustomer, ChLinkman chLinkman, CstLabel cstLabel) {
       //目标获取认领公海客户的主联系人
        CstCustomer cstCustomerResult=cstCustomerMapper.selectCstCustomerInfo(cstCustId);
        List<ChLinkman> chLinkmans=cstCustomerResult.getLinkmanList();
        ChLinkman chLinkmanFinal=null;
        for (ChLinkman chLinkmanFor:chLinkmans){
            if(chLinkmanFor.getLinkStatus()==0){
                chLinkmanFinal=chLinkmanFor;
            }
        }
        //获得的主联系人id
      Long chLinkmanId=chLinkmanFinal.getLinkId();
            //根据客户id更改客户信息
        cstCustomerMapper.updateCstCustomerById(cstCustId,cstCustomer);
        //根据主联系人id更改主联系人信息
        chLinkmanMapper.updateChLinkmanByIdAndChLinkman(chLinkmanId,chLinkman);

        //添加下级客户
        cstLowCustomer.setHighCustId(cstCustId);
        cstLowCustomerMapper.saveCstLowCustomerInfo(cstLowCustomer);

        //添加标签
        cstLabelMapper.saveCstLabel(cstLabel,userId);
        //获取标签id
        int labelId=cstLabel.getLabelId();

        //插入客户标签中间表的数据
        cstCustomerMapper.saveCstCustomerAndLabel(cstCustId,labelId);
    }


}
