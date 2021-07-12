package com.gxx.crm.query;

import com.gxx.crm.base.BaseQuery;
import lombok.Data;

/**
 * @author gxx
 * @create 2021-07-12 12:27
 */
@Data
public class UserQuery extends BaseQuery {
    private String userName; // 用户名
    private String email; // 邮箱
    private String phone; // 手机号
}
