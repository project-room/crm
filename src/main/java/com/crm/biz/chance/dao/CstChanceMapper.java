package com.crm.biz.chance.dao;

/**
 * Created by Administrator on 2017/9/12.
 */
import com.crm.entity.CstChance;

import java.util.List;

import com.crm.entity.CstCustomer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CstChanceMapper {

    CstChance findById(Long id);

    void addCstCustomer(CstChance cstChance);

    void deleteById(Long id);

    void updateCstChanceById(CstChance cstChance);
}