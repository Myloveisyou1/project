package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.SysVersion;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.SysService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 17:59
 */
@RestController
@RequestMapping(value = "/sys")
public class SysController {

    @Autowired
    private SysService sysService;

    @GetMapping(value = "/addVersion")
    public Result addVersion(SysVersion version) {

        return ResultUtil.success(sysService.addVersion(version),null);

    }

    @GetMapping(value = "/findSysVersion")
    public Result findSysVersion() {

        return ResultUtil.success(sysService.findSysVersion(),null);
    }
}
