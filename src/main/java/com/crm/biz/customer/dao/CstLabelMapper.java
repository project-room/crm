package com.crm.biz.customer.dao;

import com.crm.entity.CstLabel;
import com.crm.entity.CstLabelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
public interface CstLabelMapper {

    int countByExample(CstLabelExample example);

    int deleteByExample(CstLabelExample example);

    int deleteByPrimaryKey(Integer labelId);

    int insert(CstLabel record);

    int insertSelective(CstLabel record);

    List<CstLabel> selectByExample(CstLabelExample example);

    CstLabel selectByPrimaryKey(Integer labelId);

    int updateByExampleSelective(@Param("record") CstLabel record, @Param("example") CstLabelExample example);

    int updateByExample(@Param("record") CstLabel record, @Param("example") CstLabelExample example);

    int updateByPrimaryKeySelective(CstLabel record);

    int updateByPrimaryKey(CstLabel record);

}
