package com.jiemin.wages.domain.consume;

import java.io.Serializable;

public class ConsumeDetail implements Serializable {

    private Integer fid;

    private Integer f_consume_id;

    private String f_name;

    private double f_price;

    private String f_ctime;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getF_consume_id() {
        return f_consume_id;
    }

    public void setF_consume_id(Integer f_consume_id) {
        this.f_consume_id = f_consume_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public double getF_price() {
        return f_price;
    }

    public void setF_price(double f_price) {
        this.f_price = f_price;
    }

    public String getF_ctime() {
        return f_ctime;
    }

    public void setF_ctime(String f_ctime) {
        this.f_ctime = f_ctime;
    }
}
