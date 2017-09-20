package com.crm.biz.customer.dao;

import com.crm.entity.CstRecord;
import com.crm.entity.CstRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CstRecordMapper {
    int countByExample(CstRecordExample example);

    int deleteByExample(CstRecordExample example);

    int deleteByPrimaryKey(Long reId);

    int insert(CstRecord record);

    int insertSelective(CstRecord record);

    List<CstRecord> selectByExample(CstRecordExample example);

    CstRecord selectByPrimaryKey(Long reId);

    int updateByExampleSelective(@Param("record") CstRecord record, @Param("example") CstRecordExample example);

    int updateByExample(@Param("record") CstRecord record, @Param("example") CstRecordExample example);

    int updateByPrimaryKeySelective(CstRecord record);

    int updateByPrimaryKey(CstRecord record);
}