package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.Logs;
import com.flowyj.pcenter.domain.common.Pages;
import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.exception.PCenterException;
import com.flowyj.pcenter.mapper.LogsMapper;
import com.flowyj.pcenter.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Descript: 日志管理
 * @Author: liuyingjie
 * @Date: create in 2018/5/14 0014 14:10
 */
@Service
public class LogService {

    @Autowired
    private LogsMapper logsMapper;

    /**
     * 保存日志信息
     * @param logs
     */
    public void optSaveLogs(Logs logs) {

        if(CommonUtil.isNotEmpty(logs)) {
            logsMapper.optSaveLogs(logs);
        }
    }

    /**
     * 修改日志信息
     * @param logs
     */
    public void optUpdateLogs(Logs logs) {

        if(CommonUtil.isNotEmpty(logs)) {
            logsMapper.optUpdateLogs(logs);
        }
    }

    /**
     * 分页查询日志信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object> pagingQueryLogs(Integer pageNum,Integer pageSize) {

        Integer start = 0,end = 0;
        Pages pages = new Pages();
        Map<String,Object> map = new HashMap<>();
        if (pageNum < 1 || pageSize < 1) {
            throw new PCenterException(ResultEnum.PAGENUM_ERROR);
        }
        if (pageNum == 1) {
            pages.setFirst(true);
            pages.setLast(false);
        } else {
            pages.setFirst(false);

        }
        start = (pageNum-1)*pageSize;
        end = pageSize;


        List<Logs> list = logsMapper.pagingQueryLogs(start,end);
        int count = logsMapper.pagingQueryLogsCount();

        pages.setTotalPage((count%pageSize) > 0?((count/pageSize)+1):(count/pageSize));
        pages.setTotalCount(count);
        if (pages.getPageNumber() == pages.getTotalPage()) {
            pages.setLast(true);
        }

        map.put("list",list);
        map.put("pages",pages);
        return map;
    }
}
