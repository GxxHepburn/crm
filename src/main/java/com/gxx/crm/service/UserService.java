package com.gxx.crm.service;

import com.gxx.crm.base.BaseService;
import com.gxx.crm.dao.UserMapper;
import com.gxx.crm.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-06 3:27
 */
@Service
public class UserService extends BaseService<User, Integer> {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     * 1.参数判断，判断用户性名、用户密码非空
     *      如果参数为空，抛出异常（异常被控制层捕获并处理）
     * 2.调用数据访问层，通过用户名查询用户记录，并返回用户对象
     * 3.判断用户对象是否为空
     *      如果对象为空，抛出异常（异常被控制层捕获并处理）
     * 4.判断密码是否正确，比较客户端传递的用户密码与数据库中查询的用户对象中的用户密码
     *      如果密码不相等，抛出异常（异常被控制层捕获并处理）
     * 5.如果密码正确，登陆成功
     * @param userName
     * @param userPwd
     */
    public void userLogin(String userName, String userPwd) {
        /* 1. 参数判断，判断用户性名、用户密码非空 */
        checkLoginParams(userName, userPwd);
    }

    /**
     * 参数判断
     * @param userName
     * @param pwd
     * @return void
     */
    private void checkLoginParams(String userName, String pwd) {


    }
}
