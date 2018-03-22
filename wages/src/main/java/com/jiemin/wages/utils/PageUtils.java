package com.jiemin.wages.utils;

import com.jiemin.wages.domain.Page;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/1/8 0008 15:28
 */
public class PageUtils {

    public static Page pageDetail(Page page){

        page.setTotalPage(page.getPageCount()/page.getPageSize()+(page.getPageCount()%page.getPageSize()==0?0:1));

        return page;
    }
}
