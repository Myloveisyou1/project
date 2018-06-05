package com.flowyj.pcenter.domain;

import lombok.Data;

/**
 * @Descript: 薪资扣费类型配置
 * @Author: liuyingjie
 * @Date: create in 2018/6/5 0005 11:38
 */
@Data
public class SalaryType {

    private Long gid;

    private Integer sType;

    private String sName;

    private Integer sDeductionsType;

    private Long sDeductionsValue;

    private Integer sOperationType;

    private Long version;

    private String createTime;

    private String updateTime;

    private Integer status;

}
