package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.base.ResultInfo;
import com.gxx.crm.query.CusDevPlanQuery;
import com.gxx.crm.service.CusDevPlanService;
import com.gxx.crm.service.SaleChanceService;
import com.gxx.crm.vo.CusDevPlan;
import com.gxx.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author gxx
 * @create 2021-07-10 17:28
 */
@RequestMapping("/cus_dev_plan")
@Controller
public class CusDevPlanController extends BaseController {

    @Resource
    SaleChanceService saleChanceService;

    @Resource
    CusDevPlanService cusDevPlanService;

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

    /**
     * 客户开发计划数据查询（分页多条件查询）
     * @param cusDevPlanQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryCusDevPlanByParams(CusDevPlanQuery cusDevPlanQuery) {
        return cusDevPlanService.queryCusDevPlanByParams(cusDevPlanQuery);
    }

    /**
     * 添加计划项
     * @param cusDevPlan
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultInfo addCusDevPlan(CusDevPlan cusDevPlan) {
        cusDevPlanService.addCusDevPlan(cusDevPlan);
        return success("计划项添加成功！");
    }

    /**
     * 进入添加或修改计划项的页面
     * @return
     */
    @RequestMapping("/toAddOrUpdateCusDevPlanPage")
    public String toAddOrUpdateCusDevPlanPage(Integer sId, HttpServletRequest request) {
        // 将营销机会ID设置到请求域中，给计划项页面获取
        request.setAttribute("sId", sId);
        return "cusDevPlan/add_update";
    }
}
