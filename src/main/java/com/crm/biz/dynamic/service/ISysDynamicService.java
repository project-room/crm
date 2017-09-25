package com.crm.biz.dynamic.service;

import com.crm.entity.SysDynamic;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface ISysDynamicService {

    //通过用户id查询所有动态
    public List<SysDynamic> selectDynamicByUserId();
}
