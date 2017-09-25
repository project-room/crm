package com.crm.biz.dynamic.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.SysDynamic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
@Component
public interface SysDynamicMapper {
    SysDynamic findById(Long id);

    void addSysDynamic(SysDynamic sysDynamic);

    void deleteById(Long id);

    void updateSysDynamicById(SysDynamic sysDynamic);

}
