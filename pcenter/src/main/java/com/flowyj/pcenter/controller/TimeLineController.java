package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.TimeLineService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript: 时间轴
 * @Author: liuyingjie
 * @Date: create in 2018/5/28 0028 15:46
 */
@RestController
@RequestMapping(value = "/timeLine")
public class TimeLineController {

    @Autowired
    private TimeLineService service;

    @GetMapping(value = "/list")
    public Result list(@RequestParam(value = "userName") String userName) {

        return ResultUtil.success(service.queryTimeLineList(userName),null);
    }
}
