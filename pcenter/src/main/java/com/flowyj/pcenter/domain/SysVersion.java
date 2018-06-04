package com.flowyj.pcenter.domain;

import lombok.Data;

/**
 * @Descript: 项目更新版本
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 17:57
 */
@Data
public class SysVersion {

    private Long gid;

    private String msg;

    private String version;

    private String updateTime;
}
