package com.jiemin.wages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/26 0026 9:21
 */
@Controller

public class IndexController {

    @RequestMapping(value = "/main")
    public String index() {

        return "main";
    }

    @RequestMapping(value = "/staff")
    public String staff() {

        return "views/staff";
    }

    @RequestMapping(value = "/test")
    public String test() {

        return "test";
    }
}
