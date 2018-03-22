package com.jiemin.wages.domain;

import java.io.Serializable;

/**
 * @Descript: 分页数据
 * @Author: liuyingjie
 * @Date: create in 2018/1/6 0006 14:31
 */
public class Page implements Serializable{

    private Integer pageSize;//每页数据

    private Integer pageNumber;//页码

    private Integer pageCount;//总数据

    private Integer totalPage;//总页码

    private Integer targetPage;//总查询使用的数据

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(Integer targetPage) {
        this.targetPage = targetPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", pageCount=" + pageCount +
                ", totalPage=" + totalPage +
                ", targetPage=" + targetPage +
                '}';
    }
}
