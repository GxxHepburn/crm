package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.service.SaleChanceService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-09 6:11
 */
@Controller
public class SaleChanceController extends BaseController {

    @Resource
    private SaleChanceService saleChanceService;
}
