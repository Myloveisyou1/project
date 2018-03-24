package com.jiemin.wages.controller;

import com.jiemin.wages.domain.SalaryType;
import com.jiemin.wages.domain.common.Pages;
import com.jiemin.wages.domain.common.Result;
import com.jiemin.wages.service.SalaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 16:19
 */
@RestController
@RequestMapping(value = "/salaryType")
public class SalaryTypeController {

    @Autowired
    private SalaryTypeService service;

    /**
     * 添加工资类型
     * @param salaryType
     * @return
     */
    @RequestMapping(value = "/saveSalaryType")
    public Result saveSalaryType(SalaryType salaryType) {

        return service.saveSalaryType(salaryType);
    }

    /**
     * 根据工资类型名称分页查询
     * @param page
     * @param userName
     * @return
     */
    @RequestMapping(value = "/findSalaryTypeByPage")
    public Result findSalaryTypeByPage(Pages page, String userName) {

        return service.findSalaryTypeByPage(page.getPageNumber(),page.getPageSize(),userName);
    }

    /**
     * 删除信息根据gid
     * @param gid
     * @return
     */
    @RequestMapping(value = "/delByGid")
    public Result deleteByGid(Long gid) {

        return service.delByGid(gid);
    }

    /**
     * 修改工资类型信息
     * @param salaryType
     * @return
     */
    @RequestMapping(value = "/updateSalaryType")
    public Result updateSalaryType(SalaryType salaryType) {

        return service.updateSalaryType(salaryType);
    }


}
