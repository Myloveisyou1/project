package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    @Select("select * from user where user_name = #{userName}")
    User findByUserName(String userName);

    /**
     * 账号密码查询
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from user where user_name = #{userName} AND password = #{password}")
    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
