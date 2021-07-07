package com.gxx.crm.dao;

import com.gxx.crm.base.BaseMapper;
import com.gxx.crm.vo.User;

public interface UserMapper extends BaseMapper<User, Integer> {

    // 通过用户名查询用户记录，返回用户对象
    public User queryUserByName(String userName);
}