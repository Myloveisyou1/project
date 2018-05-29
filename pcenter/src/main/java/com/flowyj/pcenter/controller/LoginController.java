package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.LoginService;
import com.flowyj.pcenter.utils.CommonUtil;
import com.flowyj.pcenter.utils.MD5Util;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * 登陆
     * @param userName
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password){

        //校验登陆
        Map<String,Object> map = service.findUser(userName, MD5Util.getMD5(password));

        if(CommonUtil.isNotEmpty(map.get("sessionId"))){
            return ResultUtil.success(map,null);
        }else{
            return null;
        }
    }

    /**
     * 退出登陆
     * @param sessionId
     * @return
     */
    @GetMapping(value = "/loginOut")
    public Result loginOut(String sessionId){


        return ResultUtil.success(service.loginOut(sessionId),null);

    }
}
