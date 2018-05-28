package com.flowyj.pcenter.domain;

import com.flowyj.pcenter.domain.common.Base;
import lombok.Data;

import java.util.List;

/**
 * @Descript:时间轴
 * @Author: liuyingjie
 * @Date: create in 2018/5/28 0028 15:41
 */
@Data
public class TimeLine extends Base{

    private Long gid;
    private String icon;
    private String content;
    private String createUser;
    private List<TimeLine> list;

}
