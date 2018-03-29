package com.jiemin.wages.utils;
import com.jiemin.wages.domain.common.Pages;
import lombok.Data;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/1/8 0008 15:28
 */
@Data
public class PageUtils {

    public static Pages detail(int pageNumber, int pageSize,int totalCount) {

        Pages page = new Pages();
        boolean first = false, last = false;
        int totalPages = 0;
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        if(pageNumber == 1) {
            first = true;
        }
        page.setFirst(first);
        page.setLast(last);
        totalPages = (totalCount%pageSize) > 0 ? (totalCount/pageSize+1) : (totalCount/pageSize);
        page.setTotalPage(totalPages);
        page.setTotalCount(totalCount);
        return page;
    }
}
