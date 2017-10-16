package com.crm.biz.customer.service;

import com.crm.entity.CstSchedule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */
public interface ICstScheduleService {

    public List<CstSchedule> getCstSchedule(Long chId);

    public  boolean deleteCstSchedule(Long chId);
}
