package com.crm.biz.customer.service;


import com.crm.common.Page;
import com.crm.entity.*;

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
    Page<CstCustomer> getCstCustomerOnePageInfo(int currentPage,int pageSize);

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
    List<CstCustomer> selectCstCustomerByName(String custCompany);

    /**
     * 查看所有认领的公海客户
     * @return
     */
    List<CstCustomer> selectAllCstCutomer();
}
