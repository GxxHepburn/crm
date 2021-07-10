package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gxx
 * @create 2021-07-10 17:28
 */
@RequestMapping("/cus_dev_plan")
@Controller
public class CusDevPlanController extends BaseController {

    /**
     * 进入客户开发计划页面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "cusDevPlan/cus_dev_plan";
    }
}
