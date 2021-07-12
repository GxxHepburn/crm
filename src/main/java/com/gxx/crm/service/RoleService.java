package com.gxx.crm.service;

import com.gxx.crm.base.BaseService;
import com.gxx.crm.dao.RoleMapper;
import com.gxx.crm.vo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author gxx
 * @create 2021-07-12 23:12
 */
@Service
public class RoleService extends BaseService<Role, Integer> {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询所有的角色列表
     * @return
     */
    public List<Map<String, Object>> queryAllRoles() {
        return roleMapper.queryAllRoles();
    }
}
