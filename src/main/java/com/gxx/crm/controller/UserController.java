package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-06 3:28
 */
@Controller
public class UserController extends BaseController {

    @Resource
    private UserService userService;
}
