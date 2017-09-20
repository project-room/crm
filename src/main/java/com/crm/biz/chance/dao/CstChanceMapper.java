package com.crm.biz.chance.dao;

/**
 * Created by Administrator on 2017/9/12.
 */
import com.crm.entity.CstChance;
import com.crm.entity.CstChanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CstChanceMapper {
    int countByExample(CstChanceExample example);

    int deleteByExample(CstChanceExample example);

    int deleteByPrimaryKey(Long chId);

    int insert(CstChance record);

    int insertSelective(CstChance record);

    List<CstChance> selectByExample(CstChanceExample example);

    CstChance selectByPrimaryKey(Long chId);

    int updateByExampleSelective(@Param("record") CstChance record, @Param("example") CstChanceExample example);

    int updateByExample(@Param("record") CstChance record, @Param("example") CstChanceExample example);

    int updateByPrimaryKeySelective(CstChance record);

    int updateByPrimaryKey(CstChance record);
    //根据客户id查询机会
    List<CstChance> selectListChByCstId(Long CstId);
}