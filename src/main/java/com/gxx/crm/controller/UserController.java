package com.gxx.crm.controller;

import com.gxx.crm.base.BaseController;
import com.gxx.crm.base.ResultInfo;
import com.gxx.crm.exceptions.ParamsException;
import com.gxx.crm.model.UserModel;
import com.gxx.crm.service.UserService;
import com.gxx.crm.utils.LoginUserUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gxx
 * @create 2021-07-08 1:30
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return resultInfo
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo userLogin(String userName, String userPwd) {

        ResultInfo resultInfo = new ResultInfo();

        // 调用service层登录方法
        UserModel userModel = userService.userLogin(userName, userPwd);
        // 设置ResultInfo的result的值（将数据返回给请求）
        resultInfo.setResult(userModel);

        return resultInfo;
    }

    /**
     * 用户修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @param repeatPassword
     * @return
     */
    @PostMapping("/updateUserPwd")
    @ResponseBody
    public ResultInfo updateUserPwd(HttpServletRequest request,
                                    String oldPassword, String newPassword, String repeatPassword) {
        ResultInfo resultInfo = new ResultInfo();

        // 获取cookie中的userId
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 调用Service层修改密码方法
        userService.updatePassword(userId, oldPassword, newPassword, repeatPassword);

        return resultInfo;
    }

    /**
     * 进入修改密码的页面
     * @return
     */
    @RequestMapping("/toPasswordPage")
    public String toPasswordPage() {
        return "user/password";
    }
}
