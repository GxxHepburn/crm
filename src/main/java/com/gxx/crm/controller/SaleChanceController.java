package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.base.ResultInfo;
import com.gxx.crm.query.SaleChanceQuery;
import com.gxx.crm.service.SaleChanceService;
import com.gxx.crm.utils.CookieUtil;
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
 * @create 2021-07-09 6:11
 */
@Controller
@RequestMapping("/sale_chance")
public class SaleChanceController extends BaseController {

    @Resource
    private SaleChanceService saleChanceService;

    /**
     * 营销机会数据查询 （分页多条件查询）
     * @param saleChanceQuery
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> querySaleChanceByParams(SaleChanceQuery saleChanceQuery) {
        return saleChanceService.querySaleChanceByParams(saleChanceQuery);
    }

    /**
     * 进入营销机会管理页面
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        return "saleChance/sale_chance";
    }

    /**
     * 添加营销机会
     * @param saleChance
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultInfo addSaleChance(SaleChance saleChance, HttpServletRequest request) {
        // 从cookie中获取当前登录的用户名
        String userName = CookieUtil.getCookieValue(request, "userName");
        // 设置用户名到营销机会对象
        saleChance.setCreateMan(userName);
        // 调用Service层的添加方法
        saleChanceService.addSaleChance(saleChance);
        return success("营销机会数据添加成功！");
    }

    /**
     * 进入添加/修改营销机会页面
     * @return
     */
    @RequestMapping("/toSaleChancePage")
    public String toSaleChancePage() {
        return "saleChance/add_update";
    }

    /**
     * 更新营销机会
     * @param saleChance
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo updateSaleChance(SaleChance saleChance) {
        // 调用Service层的更新方法
        saleChanceService.updateSaleChance(saleChance);
        return success("营销机会数据更新成功！");
    }
}
