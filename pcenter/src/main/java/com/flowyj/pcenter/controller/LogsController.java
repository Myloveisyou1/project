package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Pages;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.LogService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/28 0028 13:27
 */
@RestController
@RequestMapping(value = "/logs")
public class LogsController {

    @Autowired
    private LogService logService;

    @GetMapping(value = "/logsList",produces =  { "application/json;charset=UTF-8" })
    public Result findLogsList(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "startTime",required = false) String startTime,@RequestParam(value = "endTime",required = false) String endTime) {


        Map<String,Object> map = logService.pagingQueryLogs(pageNum,pageSize,startTime,endTime);
        Pages pages = (Pages) map.get("pages");
        pages.setPageNumber(pageNum);
        pages.setPageSize(pageSize);
        return ResultUtil.success(map.get("list"),pages);

    }
}
