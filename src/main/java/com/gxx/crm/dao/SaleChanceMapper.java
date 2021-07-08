package com.gxx.crm.dao;

import com.gxx.crm.base.BaseMapper;
import com.gxx.crm.vo.SaleChance;

public interface SaleChanceMapper extends BaseMapper<SaleChance, Integer> {

    /**
     * 多条件查询的接口不需要单独定义
     * 由于多模块涉及到多条件查询操作，所以将对应的多条件查询功能定义在父接口BaseMapper
     */
}