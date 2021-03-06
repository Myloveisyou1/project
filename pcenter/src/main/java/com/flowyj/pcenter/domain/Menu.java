package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.utils.Invisible;
import lombok.Data;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:38
 */
@Data
public class Menu{

    private Long gid;

    private Integer menuType;
    private String icon;
    private String menuName;
    private String url;
    private Integer parentCode;
    private Integer code;
    private Long belong;

    @Invisible
    private String projectName;

    @Invisible
    private List<Menu> menuList;

    public Long version;

    public String createTime;

    public String updateTime;

    public Integer status;
}
