package com.gxx.crm.service;

import com.gxx.crm.base.BaseService;
import com.gxx.crm.dao.SaleChanceMapper;
import com.gxx.crm.vo.SaleChance;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-09 6:08
 */
@Resource
public class SaleChanceService extends BaseService<SaleChance, Integer> {

    @Resource
    private SaleChanceMapper saleChanceMapper;
}
