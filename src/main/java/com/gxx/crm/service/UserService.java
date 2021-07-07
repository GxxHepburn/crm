package com.gxx.crm.service;

import com.gxx.crm.base.BaseService;
import com.gxx.crm.dao.UserMapper;
import com.gxx.crm.model.UserModel;
import com.gxx.crm.utils.AssertUtil;
import com.gxx.crm.utils.Md5Util;
import com.gxx.crm.utils.UserIDBase64;
import com.gxx.crm.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gxx
 * @create 2021-07-08 1:29
 */
@Service
public class UserService extends BaseService<User, Integer> {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *  1. 参数判断，判断用户名、用户密码非空
     *      如果参数为空，抛出异常（异常被控制层捕获并处理）
     *   2. 调用数据访问层，通过用户名查询用户记录，返回用户对象
     *   3. 判断用户对象是否为空
     *      如果对象为空，抛出异常（异常被控制层捕获并处理）
     *   4. 判断密码是否正确，比较客户端传递的用户密码与数据库中查询的用户对象中的用户密码
     *       如果密码不相等，抛出异常（异常被控制层捕获并处理）
     *   5. 如果密码正确，则登录成功，返回结果
     * @param userName
     * @param userPwd
     */
    public UserModel userLogin(String userName, String userPwd) {
        // 1. 参数判断，判断用户名、用户密码非空
        checkLoginParams(userName, userPwd);

        // 2. 调用数据访问层，通过用户名查询用户记录，返回用户对象
        User user = userMapper.queryUserByName(userName);

        // 3. 判断用户对象是否为空
        AssertUtil.isTrue(user == null, "用户名不存在！");

        // 4. 判断密码是否正确，比较客户端传递的用户密码与数据库中查询的用户对象中的用户密码
        checkUserPwd(userPwd, user.getUserPwd());

        // 返回构建用户对象
        return buildUserInfo(user);
    }

    /**
     * 构建需要返回给客户端的用户对象
     * @param user
     * @return userModel
     */
    private UserModel buildUserInfo(User user) {
        UserModel userModel = new UserModel();
        // 设置加密的用户id
        userModel.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        return userModel;
    }

    /**
     * 密码判断
     *  先将客户端传递的密码加密，再与数据库中查询到的密码作比较
     * @param userPwd
     * @param pwd
     */
    private void checkUserPwd(String userPwd, String pwd) {
        // 将客户端传递的密码加密
        userPwd = Md5Util.encode(userPwd);
        // 判断密码是否相等
        AssertUtil.isTrue(!userPwd.equals(pwd), "用户密码不正确！");
    }

    /**
     * 参数判断
     * @param userName
     * @param userPwd
     */
    private void checkLoginParams(String userName, String userPwd) {
        // 验证用户名
        AssertUtil.isTrue(StringUtils.isBlank(userName), "用户名不能为空！");
        // 验证密码
        AssertUtil.isTrue(StringUtils.isBlank(userPwd), "用户密码不能为空！");
    }
}
