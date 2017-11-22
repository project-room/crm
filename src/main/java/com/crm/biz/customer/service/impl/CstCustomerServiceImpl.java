package com.crm.biz.customer.service.impl;

import com.crm.biz.customer.dao.ChLinkmanMapper;
import com.crm.biz.customer.dao.CstCustomerMapper;
import com.crm.biz.customer.dao.CstLabelMapper;
import com.crm.biz.customer.dao.CstLowCustomerMapper;
import com.crm.biz.customer.service.ICstCustomerService;
import com.crm.biz.sys.dao.SysUserMapper;
import com.crm.common.Page;
import com.crm.dto.DataConditionDto;
import com.crm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public Page<CstCustomer> getCstCustomerOnePageInfo(Long userIdForPage,String roleName,int currentPage, int pageSize) {

        Long  count=cstCustomerMapper.getCstCustomerCount(userIdForPage,roleName);


       int currentPageLimit=(currentPage-1)*pageSize;
       List<CstCustomer> cstCustomers= cstCustomerMapper.getPageCstCustomerInfo(userIdForPage,roleName,currentPageLimit,pageSize);
     //通过用户id获取用户名
        for (CstCustomer cstCustomer:cstCustomers
             ) {
            Long userId=cstCustomer.getUserId();
           SysUser sysUser= sysUserMapper.findById(userId);
            String userName=sysUser.getUserName();
            cstCustomer.setRevertUserNameFromId(userName);
        }
        return new Page<CstCustomer>(currentPage,pageSize,cstCustomers,count);
    }

    @Override
    public CstCustomer lookCstCustomerInfo(Long cstCustomerId) {
     CstCustomer reCstCustomer=  cstCustomerMapper.selectCstCustomerInfo(cstCustomerId);
        return reCstCustomer;
    }

    @Override
    public List<CstCustomer> selectCstCustomerByName(Long userIdForPage,String roleName,String custCompany,Integer currentPage,Integer pageSize) {
        Integer currentPageInt=(currentPage-1)*pageSize;
        custCompany="%"+custCompany+"%";
        List<CstCustomer>  cstCustomers= cstCustomerMapper.selectCstCustomerByName(userIdForPage,roleName,custCompany,currentPageInt,pageSize);
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
    public Page<CstCustomer> selectCstCustomerByCondition(Long userIdForPage,String roleName,String userName,Date startTimeDate, Date endTimeDate, CstCustomer cstCustomer, ChLinkman chLinkman, Integer currentPage, Integer pageSize) {
        String userNameLike="%"+userName+"%";
        Integer currentPageLimit=(currentPage-1)*pageSize;
        List<CstCustomer> cstCustomers=new ArrayList<CstCustomer>();
        cstCustomer.setCustCompany("%"+cstCustomer.getCustCompany()+"%");
        chLinkman.setLinkName("%"+chLinkman.getLinkName()+"%");
        chLinkman.setLinkPhone("%"+chLinkman.getLinkPhone()+"%");
        chLinkman.setLinkLandlinePhone("%"+chLinkman.getLinkLandlinePhone()+"%");
        chLinkman.setLinkQq("%"+chLinkman.getLinkQq()+"%");
        chLinkman.setLinkEmail("%"+chLinkman.getLinkEmail()+"%");
        cstCustomers= cstCustomerMapper.selectCstCustomerByCondition(userIdForPage,roleName,userNameLike,startTimeDate,endTimeDate,cstCustomer,chLinkman,currentPageLimit,pageSize);
        //通过用户id获取用户名
        for (CstCustomer cstCustomerFor:cstCustomers
                ) {
            Long userId=cstCustomerFor.getUserId();
            SysUser sysUser= sysUserMapper.findById(userId);
            String userNameFor=sysUser.getUserName();
            cstCustomerFor.setRevertUserNameFromId(userNameFor);
        }
        Long count=cstCustomerMapper.getCountByCondition(userIdForPage,roleName,userNameLike,startTimeDate,endTimeDate,cstCustomer,chLinkman);
       return new Page<CstCustomer>(currentPageLimit,pageSize,cstCustomers,count);
    }

    /**
     * 根据模糊客户名来获取count
     * @param custCompany
     * @return
     */
    @Override
    public Long selectCountByCstCustomerName(Long userIdForPage,String roleName,String custCompany) {
       String  custCompanyStr="%"+custCompany+"%";
       Long count= cstCustomerMapper.selectCountByCstCustomerName(userIdForPage, roleName,custCompanyStr);
        return count;
    }

    /**
     * 根据客户id编辑客户信息
     * @param cstCustomer
     * @param chLinkman
     */
    @Override
    public void editCustomerById(CstCustomer cstCustomer, ChLinkman chLinkman) {

        Long cstCustId=cstCustomer.getCustId();
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
        cstCustomerMapper.updateCstCustomerWithId(cstCustId,cstCustomer);
        //根据主联系人id更改主联系人信息
        chLinkmanMapper.updateChLinkmanWithIdAndChLinkman(chLinkmanId,chLinkman);
    }

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @Override
    public SysUser selectUserById(Long userId) {
        return sysUserMapper.selectSysUserById(userId);
    }


}
