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
@Entity
@Table(name = "salary_type")
public class SalaryType implements Serializable{

    @Id
    @GeneratedValue
    private Long gid;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_mark")
    private Integer typeMark;

    @Column(name = "type_status")
    private Integer typeStatus;
}
