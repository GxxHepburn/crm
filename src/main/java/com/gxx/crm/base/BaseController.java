package com.gxx.crm.base;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gxx
 * @create 2021-07-06 2:40
 */
public class BaseController {

    // request.getContextPath()拿到的是web项目的根路径，就是webContent(MyEclipse中是webRoot)。
    // request.getContextPath()，得到工程名：/dmsd-itoo-exam-log-web；
    // /之前加上 localhost:8080  就可以直接在访问页面了
    // 本项目中就是 /crm
    @ModelAttribute
    public void preHandler(HttpServletRequest request){
        request.setAttribute("ctx", request.getContextPath());
    }

    public ResultInfo success() {
        return new ResultInfo();
    }

    public ResultInfo success(String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public ResultInfo success(String msg, Object result) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        resultInfo.setResult(result);
        return resultInfo;
    }
}
