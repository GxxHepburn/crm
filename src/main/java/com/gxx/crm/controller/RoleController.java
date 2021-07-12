package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.base.ResultInfo;
import com.gxx.crm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author gxx
 * @create 2021-07-12 23:15
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    /**
     * 查询所有的角色列表
     * @return
     */
    @RequestMapping("/queryAllRoles")
    @ResponseBody
    public List<Map<String, Object>> queryAllRoles() {
        return roleService.queryAllRoles();
    }
}
