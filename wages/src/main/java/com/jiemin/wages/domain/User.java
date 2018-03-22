package com.jiemin.wages.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 刘英杰
 * @Description: 用户实体
 * @Date: Created in 2017/12/28 0:43
 */
@Data
public class User {
    private Integer fid;
    private String f_user_name;
    private String f_user_password;
    private String f_user_realname;
    private Date f_user_login_time;
    private Integer f_user_status;
    private Date f_user_create_time;
    private Date f_user_update_time;
    private Integer f_user_version;
}
