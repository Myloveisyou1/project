package com.flowyj.pcenter.provider;

import com.flowyj.pcenter.utils.CommonUtil;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/30 0030 11:46
 */
public class UserProvider {


    public String findAllUser(String userName) {

        StringBuffer sql = new StringBuffer("select gid,user_name userName,password,tel,email,role_id roleId,role_name roleName,create_time createTime,update_time updateTime,login_time loginTime,status,version from user where 1=1");
        if (CommonUtil.isNotEmpty(userName)) {
            sql.append(" AND user_name like '%"+userName+"%'");
        }

        sql.append(" order by gid desc");

        return sql.toString();
    }
}
