package com.jiemin.wages.domain;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/1/5 0005 14:21
 */
public class TimeAxis{

    private Integer fid;

    private String f_time_axis_title;
    private Integer f_time_axis_type;
    private String f_time_axis_content;
    private String f_user;
    private String f_ctime;
    private String f_utime;
    private Integer f_version;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getF_time_axis_title() {
        return f_time_axis_title;
    }

    public void setF_time_axis_title(String f_time_axis_title) {
        this.f_time_axis_title = f_time_axis_title;
    }

    public Integer getF_time_axis_type() {
        return f_time_axis_type;
    }

    public void setF_time_axis_type(Integer f_time_axis_type) {
        this.f_time_axis_type = f_time_axis_type;
    }

    public String getF_time_axis_content() {
        return f_time_axis_content;
    }

    public void setF_time_axis_content(String f_time_axis_content) {
        this.f_time_axis_content = f_time_axis_content;
    }

    public String getF_ctime() {
        return f_ctime;
    }

    public void setF_ctime(String f_ctime) {
        this.f_ctime = f_ctime;
    }

    public String getF_utime() {
        return f_utime;
    }

    public void setF_utime(String f_utime) {
        this.f_utime = f_utime;
    }

    public Integer getF_version() {
        return f_version;
    }

    public void setF_version(Integer f_version) {
        this.f_version = f_version;
    }

    public String getF_user() {
        return f_user;
    }

    public void setF_user(String f_user) {
        this.f_user = f_user;
    }
}
