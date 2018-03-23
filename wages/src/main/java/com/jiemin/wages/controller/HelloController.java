package com.jiemin.wages.controller;

import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.domain.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 11:41
 */
@RestController
public class HelloController {

    @Autowired
    private StaffRepository staffRepository;

    @RequestMapping(value = "/say")
    public String sayHi() {

        Staff staff = new Staff();
        staff.setUserName("zhangsan");
        staff.setUserSex(1);
        staff.setUserTel("18888888888");
        staff.setEmergencyName("lisi");
        staff.setEmergencyTel("18888888889");
        staff.setBankCard("31231231231");
        staffRepository.save(staff);

        return "Hello SpringBoot3";
    }

    @RequestMapping(value = "/findStaffs")
    public List<Staff> findStaff() {

        return staffRepository.findAll();
    }
}
