package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.service.UserService;
import com.gxx.crm.utils.LoginUserUtil;
import com.gxx.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author gxx
 * @create 2021-07-06 2:40
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 系统界面欢迎页
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 后端管理主页面
     * @return
     */
    @RequestMapping("/main")
    public String main(HttpServletRequest request, HttpSession session) {
        // 获取cookie中的用户Id
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 查询用户对象，设置session作用域
        User user = userService.selectByPrimaryKey(userId);
        session.setAttribute("user", user);
        return "main";
    }
}
