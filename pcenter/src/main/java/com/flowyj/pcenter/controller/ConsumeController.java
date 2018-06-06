package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.Consume;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.ConsumeService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/6 0006 11:05
 */
@RestController
@RequestMapping(value = "/consume")
public class ConsumeController {

    @Autowired
    private ConsumeService service;

    /**
     * 查询
     * @param consume
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/findConsume")
    public Result findConsume(Consume consume, @RequestParam(value = "pageNum") Integer pageNumber, @RequestParam(value = "pageSize")Integer pageSize) {

        return ResultUtil.success(service.findConsume(consume,pageNumber,pageSize),null);
    }

    /**
     * 添加
     * @param consume
     * @return
     */
    @GetMapping(value = "/addConsume")
    public Result addConsume(Consume consume) {

        return ResultUtil.success(service.addConsume(consume),null);
    }
}
