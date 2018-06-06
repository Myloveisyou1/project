package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.utils.Invisible;
import lombok.Data;

/**
 * @Descript: 消费记录
 * @Author: liuyingjie
 * @Date: create in 2018/6/6 0006 10:21
 */
@Data
public class Consume {

    private Long gid;

    private Integer consumeType;

    private Long consumeMoney;

    private String consumeRemark;

    private Long version;

    private String createTime;

    private String updateTime;

    private Integer status;


    //额外参数
    @Invisible
    private String start;
    @Invisible
    private String end;
    @Invisible
    private String consumeTypeName;
}
