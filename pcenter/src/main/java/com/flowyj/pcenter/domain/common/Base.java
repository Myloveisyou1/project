package com.flowyj.pcenter.domain.common;

import lombok.Data;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:39
 */
@Data
public class Base {

    public Long version;

    public String createTime;

    public String updateTime;

    public Integer status;
}
