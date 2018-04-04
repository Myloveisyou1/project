package com.jiemin.wages.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Descript: 工资类型
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 16:17
 */
@Data
public class SalaryType implements Serializable{

    private Long gid;

    private Integer typeId;

    private String typeName;

    private Integer typeMark;

    private Integer typeStatus;
}
