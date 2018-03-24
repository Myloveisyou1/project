package com.jiemin.wages.controller;

import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.domain.common.Pages;
import com.jiemin.wages.domain.common.Result;
import com.jiemin.wages.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 11:41
 */
@RestController
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    /**
     * 根据员工姓名分页查询
     * @param page
     * @param userName
     * @return
     */
    @RequestMapping(value = "/findStaffByPage")
    public Result findStaffByPage(Pages page, String userName) {

        return service.findStaffByPage(page.getPageNumber(),page.getPageSize(),userName);
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
     * 添加员工
     * @param staff
     * @return
     */
    @RequestMapping(value = "/saveStaff")
    public Result addStaff(Staff staff) {

        return service.addStaff(staff);
    }

    /**
     * 修改员工
     * @param staff
     * @return
     */
    @RequestMapping(value = "/updateStaff")
    public Result updateStaff(Staff staff) {

        return service.updateStaff(staff);
    }
}
