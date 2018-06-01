package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.domain.common.Base;
import lombok.Data;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:38
 */
@Data
public class Menu extends Base{

    private Long gid;

    private String icon;
    private String menuName;
    private String url;
    private Integer parentCode;
    private Integer code;
    private Long belong;
    private String projectName;
    private List<Menu> menuList;
}
