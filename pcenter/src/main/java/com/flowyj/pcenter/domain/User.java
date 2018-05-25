package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.domain.common.Base;
import lombok.Data;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/24 0024 16:51
 */
@Data
public class User extends Base{

    private Long gid;

    private String userName;

    private String password;

    private String email;

    private Long roleId;

    private String roleName;

    private String loginTime;

}
