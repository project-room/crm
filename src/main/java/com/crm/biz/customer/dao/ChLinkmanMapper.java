package com.crm.biz.customer.dao;

import com.crm.entity.ChLinkman;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/24.
 */
@Component
public interface ChLinkmanMapper {
  void saveChLinkman(ChLinkman chLinkman);
}
