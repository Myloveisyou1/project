package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.BasicInfo;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.EmailService;
import com.flowyj.pcenter.service.GoodsService;
import com.flowyj.pcenter.service.SalaryService;
import com.flowyj.pcenter.service.UserService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript: 主页
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 17:36
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SalaryService salaryService;


    @GetMapping(value = "/findBasicInfo")
    public Result findBasicInfo() {

        BasicInfo basicInfo = new BasicInfo();
        //用户总数
        int userCount = userService.findAllUser(null).size();
        /*int emailCount = emailService.findAllEmails(null).size();
        int goodsCount = goodsService.findAllGoods(null).size();
        int salaryCount = salaryService.findAllSalary(null).size();*/
        int emailCount = 0;
        int goodsCount = 0;
        int salaryCount = 0;

        basicInfo.setUserCount(userCount);
        basicInfo.setEmailCount(emailCount);
        basicInfo.setGoodsCount(goodsCount);
        basicInfo.setSalaryCount(salaryCount);

        return ResultUtil.success(basicInfo,null);
    }
}
