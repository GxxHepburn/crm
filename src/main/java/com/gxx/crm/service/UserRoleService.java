package com.gxx.crm.service;

import com.gxx.crm.base.BaseService;
import com.gxx.crm.dao.UserRoleMapper;
import com.gxx.crm.vo.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-13 13:20
 */
@Service
public class UserRoleService extends BaseService<UserRole, Integer> {

    @Resource
    private UserRoleMapper userRoleMapper;
}
