package com.flowyj.pcenter.domain.common;

import lombok.Data;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:39
 */
@Data
public class Base {

    private Long version;

    private String createTime;

    private String updateTime;

    private Integer status;
}
