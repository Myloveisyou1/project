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

    public static Pages detail(int pageNumber, int pageSize,boolean first, boolean last, int totalPages, long totalCount) {

        Pages page = new Pages();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setFirst(first);
        page.setLast(last);
        page.setTotalPage(totalPages);
        page.setTotalCount(totalCount);
        return page;
    }
}
