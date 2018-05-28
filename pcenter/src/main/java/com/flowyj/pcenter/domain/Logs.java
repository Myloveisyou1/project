package com.flowyj.pcenter.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Descript: 系统日志
 * @Author: liuyingjie
 * @Date: create in 2018/5/14 0014 14:03
 */
@Data
public class Logs {

    private Long gid;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 请求ip
     */
    private String ip;
    /**
     * 请求方法名称
     */
    private String classMethod;
    /**
     * 参数名称和参数值
     */
    private String args;
    /**
     * 请求开始时间
     */
    private String startTime;
    /**
     * 请求结束时间
     */
    private String endTime;
    /**
     * 消耗时间s
     */
    private Long time;
    /**
     * 返回值
     */
    private String repData;
}
