package com.crm.biz.dynamic.dao;

import com.crm.entity.SysDynamic;
import com.crm.entity.SysDynamicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
    public interface SysDynamicMapper {
        int countByExample(SysDynamicExample example);

        int deleteByExample(SysDynamicExample example);

        int deleteByPrimaryKey(Long dyId);

        int insert(SysDynamic record);

        int insertSelective(SysDynamic record);

        List<SysDynamic> selectByExample(SysDynamicExample example);

        SysDynamic selectByPrimaryKey(Long dyId);

        int updateByExampleSelective(@Param("record") SysDynamic record, @Param("example") SysDynamicExample example);

    int updateByExample(@Param("record") SysDynamic record, @Param("example") SysDynamicExample example);

    int updateByPrimaryKeySelective(SysDynamic record);

    int updateByPrimaryKey(SysDynamic record);
}
