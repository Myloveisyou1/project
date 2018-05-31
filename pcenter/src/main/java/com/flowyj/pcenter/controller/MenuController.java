package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.MenuService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript: 权限菜单
 * @Author: liuyingjie
 * @Date: create in 2018/5/31 0031 10:31
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    /**
     * 查询所有权限菜单
     * @return
     */
    @GetMapping(value = "/findAllMenu")
    public Result findAllMenu() {

        return ResultUtil.success(service.findAllMenu(),null);
    }
}
