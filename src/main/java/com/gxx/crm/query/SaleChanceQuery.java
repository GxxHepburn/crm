package com.gxx.crm.query;

import com.gxx.crm.base.BaseQuery;
import lombok.Data;

/**
 * 营销机会的查询类
 * @author gxx
 * @create 2021-07-09 6:21
 */
@Data
public class SaleChanceQuery extends BaseQuery {

    // 分页参数

    // 条件查询
    private String customerName; // 客户名
    private String createMan; // 创建人
    private Integer state; // 分配状态 0=未分配 1=已分配
}
