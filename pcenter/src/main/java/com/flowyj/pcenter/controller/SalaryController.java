package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.SalaryType;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.SalaryService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:   薪资管理
 * @Author: liuyingjie
 * @Date: create in 2018/6/5 0005 11:36
 */
@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

    @Autowired
    private SalaryService service;

    /**
     * 查询工资消费类型
     * @param salaryType
     * @return
     */
    @GetMapping(value = "/findSalaryType")
    public Result findSalaryType(SalaryType salaryType) {

        return ResultUtil.success(service.findSalaryType(salaryType),null);
    }

    /**
     * 添加工资消费类型
     * @param salaryType
     * @return
     */
    @GetMapping(value = "/addSalaryType")
    public Result addSalaryType(SalaryType salaryType) {

        return ResultUtil.success(service.addSalaryType(salaryType),null);
    }
    /**
     * 编辑添加工资消费类型
     * @param salaryType
     * @return
     */
    @GetMapping(value = "/updateSalaryType")
    public Result updateSalaryType(SalaryType salaryType) {

        return ResultUtil.success(service.updateSalaryType(salaryType),null);
    }
    /**
     * 删除工资消费类型
     * @param gid
     * @return
     */
    @GetMapping(value = "/delSalaryType")
    public Result delSalaryType(Long gid) {

        return ResultUtil.success(service.delSalaryType(gid),null);
    }
    /**
     * 删除工资消费类型
     * @param gid
     * @return
     */
    @GetMapping(value = "/findById")
    public Result findById(Long gid) {

        return ResultUtil.success(service.findById(gid),null);
    }
}
