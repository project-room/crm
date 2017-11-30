package com.crm.biz.customer.service;


import com.crm.common.Page;
import com.crm.dto.DataConditionDto;
import com.crm.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface ICstCustomerService {
    /**
     * 认领公海客户
     *
     * @param cstCustomer
     * @return
     */
    public void cliamCstCustomer(CstCustomer cstCustomer, ChLinkman chLinkman);

    /**
     * 获取一页公海客户的信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<CstCustomer> getCstCustomerOnePageInfo(Long userIdForPage,String roleName,int currentPage,int pageSize);

    /**
     * 根据id显示公海客户信息
     * @param cstCustomerId
     * @return
     */
    CstCustomer lookCstCustomerInfo(Long cstCustomerId);

    /**
     * 根据客户名称模糊匹配客户
     * @param custCompany
     * @return
     */
    List<CstCustomer> selectCstCustomerByName(Long userIdForPage,String roleName,String custCompany,Integer currentPage,Integer pageSize);

    /**
     * 查看所有认领的公海客户
     * @return
     */
    List<CstCustomer> selectAllCstCutomer();

    /**
     * 根据认领公海客户id删除公海客户
     * @param id
     */
    void deleteCstCustomerById(Long id);

    /**
     * 编辑认领公海客户信息
     * @param cstCustomer
     * @param chLinkman
     * @param cstLabels
     */
    void editCstCustomerInfo(Long custId,Long userId,CstCustomer cstCustomer,List<CstLowCustomer> cstLowCustomers,ChLinkman chLinkman,List<CstLabel> cstLabels);

    /**
     * 新建公海客户
     * @param cstCustomer
     */
    Long createCstCustomer(CstCustomer cstCustomer,ChLinkman chLinkman);

    /**
     * 筛选公海客户
     * @param cstCustomer
     * @param chLinkman
     * @return
     */
    Page<CstCustomer> selectCstCustomerByCondition(Long userIdForPage,String roleName,String userName,Date startTimeDate, Date endTimeDate, CstCustomer cstCustomer, ChLinkman chLinkman, int currentPage, int pageSize,String startTimeStr );

    /**
     * 根据模糊客户名来获取count
     * @param custCompany
     * @return
     */
    Long selectCountByCstCustomerName(Long userIdForPage,String roleName,String custCompany);
    /**
     * 根据客户id编辑客户信息
     * @param cstCustomer
     * @param chLinkman
     */
    void editCustomerById(CstCustomer cstCustomer,ChLinkman chLinkman);

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    SysUser selectUserById(Long userId);

    /**
     * 更改客户的用户id
     */
    void updateCstCustomerSysUserProperties(Long custIdLong,Long userIdLong,Integer flagDistri);

    //加载销售员列表
    List<SysUser> bySysUserList(Long roleId,String district,int userStatus);

    //首页动态添加客户
    void addCstCustomerSysDynamic(Long userId,String userName,Long roleId,int dyClassify,String dyContent,Date date,Long custId,String custCompany);

}
