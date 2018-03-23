package com.jiemin.wages.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 16:37
 */
@Data
@Entity
@Table(name = "staff")
public class Staff implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long gid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "emergency_name")
    private String emergencyName;

    @Column(name = "emergency_tel")
    private String emergencyTel;

    @Column(name = "bank_card")
    private String bankCard;
}
