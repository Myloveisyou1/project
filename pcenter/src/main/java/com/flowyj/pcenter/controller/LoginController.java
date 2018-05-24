package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {



    @PostMapping(value = "/login")
    public Result login(){


        return ResultUtil.success();
    }
}
