package com.gxx.crm.base;

import lombok.Data;

/**
 * @author gxx
 * @create 2021-07-06 2:50
 */
@Data
public class BaseQuery {

    private Integer page = 1;
    private Integer limit = 10;
}
