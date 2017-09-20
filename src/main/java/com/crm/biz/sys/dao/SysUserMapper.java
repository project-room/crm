package com.crm.biz.sys.dao;

import com.crm.entity.SysUser;
import com.crm.entity.SysUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Component
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByAccount(@Param("userAccounts")String userAccounts);

<<<<<<< HEAD
    SysUser selectById(@Param("id") Long id);

    Integer getCount();

    List<SysUser> getOnePageInfo(@Param("currenPage") Integer currenPage,@Param("pageSize") Integer pageSize);
=======
    //根据用户id查询客户表数据
    SysUser selectCustomerList(Long userId);
>>>>>>> crm/eee
}