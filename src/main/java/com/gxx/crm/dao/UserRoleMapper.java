package com.gxx.crm.dao;

import com.gxx.crm.base.BaseMapper;
import com.gxx.crm.vo.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole, Integer> {
    // 根据用户ID删除用户角色记录
    Integer deleteUserRoleByUserId(Integer userId);

    // 根据用户ID查询用户角色记录
    Integer countUserRoleByUserId(Integer userId);
}