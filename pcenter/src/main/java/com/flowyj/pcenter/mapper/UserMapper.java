package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.User;
import com.flowyj.pcenter.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/24 0024 16:50
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * 根据登录名查询
     * @param userName
     * @return
     */
    @Select("select gid,user_name userName,password,email,role_id roleId,role_name roleName,create_time createTime,update_time updateTime,login_time loginTime,status from user where user_name = #{userName}")
    User findByUserName(String userName);

    /**
     * 账号密码查询
     * @param userName
     * @param password
     * @return
     */
    @Select("select gid,user_name userName,password,email,role_id roleId,role_name roleName,create_time createTime,update_time updateTime,login_time loginTime,status from user where user_name = #{userName} AND password = #{password}")
    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    @Update("update user (#{user}) where gid = #{gid}")
    @Lang(SimpleUpdateLangDriver.class)
    void optUpdateUser(User user);
}
