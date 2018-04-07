package com.jiemin.wages.domain;

import lombok.Data;
import org.springframework.data.annotation.Transient;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 16:37
 */
@Data
public class Staff{

    private Long gid;

    private String userName;

    private Integer userSex;

    private String sex;

    private String userTel;

    private String emergencyName;

    private String emergencyTel;

    private String bankCard;

    private String createTime;
}
