package com.gxx.crm.dao;

import com.gxx.crm.base.BaseMapper;
import com.gxx.crm.vo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gxx
 * @create 2021-07-06 3:25
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    @Select("SELECT * FROM t_user WHERE user_name = #{userName}")
    public User queryUserByName(@Param("userName") String uname);
}
