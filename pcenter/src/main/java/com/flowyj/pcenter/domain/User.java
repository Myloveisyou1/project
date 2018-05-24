package com.flowyj.pcenter.domain;

import lombok.Data;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/24 0024 16:51
 */
@Data
public class User {

    private Long gid;

    private String userName;

    private String password;

    private String email;

    private String createTime;

    private String updateTime;

    private String loginTime;

    private Integer status;

}
