package com.gxx.crm.base;

import lombok.Data;

/**
 * @author gxx
 * @create 2021-07-06 2:51
 */
@Data
public class ResultInfo {

    private Integer code = 200;
    private String msg = "success";

    private Object result;
}
