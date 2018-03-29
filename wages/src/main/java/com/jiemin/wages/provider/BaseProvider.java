package com.jiemin.wages.provider;

import com.jiemin.wages.utils.CommonUtil;

/**
 * @Descript: 动态拼接sql,返回sql
 * @Author: liuyingjie
 * @Date: create in 2018/3/28 0028 11:07
 */
public class BaseProvider {

    public String findStaffPaging(String userName, Integer pageNumber, Integer pageSize) {

        StringBuffer sql = new StringBuffer("select gid,user_name as userName,user_tel as userTel,user_sex as userSex,bank_card as bankCard,emergency_name as emergencyName,emergency_tel as emergencyTel,create_time as createTime from staff where 1=1");

        if(CommonUtil.isNotEmpty(userName)) {
            sql.append(" AND user_name='"+userName+"'");
        }
        sql.append(" limit "+(pageNumber-1)*pageSize+","+pageSize);
        return sql.toString();
    }
    public String findStaffCount(String userName) {

        StringBuffer sql = new StringBuffer("select count(0) from staff where 1=1");

        if(CommonUtil.isNotEmpty(userName)) {
            sql.append(" AND user_name='"+userName+"'");
        }
        return sql.toString();
    }
}
