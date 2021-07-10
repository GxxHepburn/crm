package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.service.SaleChanceService;
import com.gxx.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gxx
 * @create 2021-07-10 17:28
 */
@RequestMapping("/cus_dev_plan")
@Controller
public class CusDevPlanController extends BaseController {

    @Resource
    SaleChanceService saleChanceService;

    /**
     * 进入客户开发计划页面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "cusDevPlan/cus_dev_plan";
    }

    /**
     * 打开计划项开发与详情页面
     * @param id
     * @return
     */
    @RequestMapping("/toCusDevPlanPage")
    public String index(Integer id, HttpServletRequest request) {

        // 通过id查询营销机会对象
        SaleChance saleChance = saleChanceService.selectByPrimaryKey(id);
        // 将对象设置到请求域中
        request.setAttribute("saleChance", saleChance);
        return "cusDevPlan/cus_dev_plan_data";
    }
}
