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

import java.util.ArrayList;
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
       int currentPageLimit=(currentPage-1)*pageSize;
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
    public void editCstCustomerInfo(Long cstCustId,Long userId,CstCustomer cstCustomer,List<CstLowCustomer> cstLowCustomers, ChLinkman chLinkman, List<CstLabel> cstLabels) {
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
//        cstLowCustomer.setHighCustId(cstCustId);
        for (CstLowCustomer cstLowCustomer:cstLowCustomers
             ) {
            cstLowCustomerMapper.saveCstLowCustomerInfo(cstLowCustomer);
        }


        //添加标签
        for (CstLabel cstLabel:cstLabels
             ) {
            cstLabelMapper.saveCstLabel(cstLabel,userId);
            //获取标签id
            int labelId=cstLabel.getLabelId();
            //插入客户标签中间表的数据
            cstCustomerMapper.saveCstCustomerAndLabel(cstCustId,labelId);
        }




    }

    /**
     * 创建客户
     * @param cstCustomer
     * @param chLinkman
     */
    @Override
    public void createCstCustomer(CstCustomer cstCustomer,ChLinkman chLinkman) {
        cstCustomerMapper.saveCstCustomer(cstCustomer);
        Long custId=cstCustomer.getCustId();
        chLinkman.setCustId(custId);
        chLinkmanMapper.saveChLinkman(chLinkman);

    }

    /**
     * 筛选客户
     * @param cstCustomer
     * @param chLinkman
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<CstCustomer> selectCstCustomerByCondition(CstCustomer cstCustomer, ChLinkman chLinkman,Integer currentPage,Integer pageSize) {
       Integer currentPageLimit=(currentPage-1)*pageSize;
       List<CstCustomer> cstCustomers=new ArrayList<CstCustomer>();
        cstCustomer.setCustCompany("%"+cstCustomer.getCustCompany()+"%");
        chLinkman.setLinkName("%"+chLinkman.getLinkName()+"%");
        chLinkman.setLinkPhone("%"+chLinkman.getLinkPhone()+"%");
        chLinkman.setLinkLandlinePhone("%"+chLinkman.getLinkLandlinePhone()+"%");
        chLinkman.setLinkQq("%"+chLinkman.getLinkQq()+"%");
        chLinkman.setLinkEmail("%"+chLinkman.getLinkEmail()+"%");
        cstCustomers= cstCustomerMapper.selectCstCustomerByCondition(cstCustomer,chLinkman,currentPageLimit,pageSize);
        Long count=cstCustomerMapper.getCountByCondition(cstCustomer,chLinkman);
       return new Page<CstCustomer>(currentPageLimit,pageSize,cstCustomers,count);
    }


}
