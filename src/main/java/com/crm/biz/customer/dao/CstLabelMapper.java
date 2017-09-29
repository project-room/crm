package com.crm.biz.customer.dao;

import com.crm.entity.CstCustomer;
import com.crm.entity.CstLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface CstLabelMapper {
    CstLabel findById(Long id);

    void addCstLabel(CstLabel cstLabel);

    void deleteById(Long id);

    void updateCstLabelById(CstLabel cstLabel);

    void saveCstLabel(@Param("cstLabel") CstLabel cstLabel,@Param("userId") Long userId);
}
