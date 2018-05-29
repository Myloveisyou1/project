package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.RoleService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/29 0029 17:39
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping(value = "/findAllRole")
    public Result findAllRole() {

        return ResultUtil.success(service.findAllRole(),null);
    }
}
