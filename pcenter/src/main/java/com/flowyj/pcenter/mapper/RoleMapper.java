package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/29 0029 17:37
 */
@Component
@Mapper
public interface RoleMapper {

    @Select("select gid,role_name roleName,role_name_en roleNameEn,version,create_time createTime,update_time updateTime,status from role where 1=1")
    List<Role> findAllRole();

    @Select("select gid,role_name roleName,role_name_en roleNameEn,version,create_time createTime,update_time updateTime,status from role where gid = #{gid}")
    Role findById(@Param("gid") Long roleId);
}
