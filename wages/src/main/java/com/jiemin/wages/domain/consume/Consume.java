package com.jiemin.wages.domain.consume;

import java.io.Serializable;
import java.util.Date;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/1/8 0008 10:21
 */
public class Consume implements Serializable{

    private Integer fid;
    private double f_consume_money;
    private String f_consume_type;
    private String f_consume_remark;
    private String f_consume_time;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public double getF_consume_money() {
        return f_consume_money;
    }

    public void setF_consume_money(double f_consume_money) {
        this.f_consume_money = f_consume_money;
    }

    public String getF_consume_type() {
        return f_consume_type;
    }

    public void setF_consume_type(String f_consume_type) {
        this.f_consume_type = f_consume_type;
    }

    public String getF_consume_remark() {
        return f_consume_remark;
    }

    public void setF_consume_remark(String f_consume_remark) {
        this.f_consume_remark = f_consume_remark;
    }

    public String getF_consume_time() {
        return f_consume_time;
    }

    public void setF_consume_time(String f_consume_time) {
        this.f_consume_time = f_consume_time;
    }
}
