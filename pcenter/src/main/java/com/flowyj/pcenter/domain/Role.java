package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.domain.common.Base;
import lombok.Data;

/**
 * @Descript:  角色实体
 * @Author: liuyingjie
 * @Date: create in 2018/5/29 0029 17:35
 */
@Data
public class Role extends Base{

    private Long gid;

    private String roleName;

    private String roleNameEn;
}
