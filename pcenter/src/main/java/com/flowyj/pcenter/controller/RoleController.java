package com.flowyj.pcenter.controller;

import com.flowyj.pcenter.domain.Role;
import com.flowyj.pcenter.domain.common.Result;
import com.flowyj.pcenter.service.RoleService;
import com.flowyj.pcenter.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/29 0029 17:39
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService service;

    /**
     * 查询所有角色
     * @param roleName
     * @return
     */
    @GetMapping(value = "/findAllRole")
    public Result findAllRole(@RequestParam(value = "roleName",required = false) String roleName) {

        return ResultUtil.success(service.findAllRole(roleName),null);
    }
    /**所有角色
     * @param roleId
     * @return
     */
    @GetMapping(value = "/findRoleById")
    public Result findRoleById(@RequestParam(value = "roleId") Long roleId) {

        return ResultUtil.success(service.findMenuByRole(roleId),null);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @GetMapping(value = "/updateRole")
    public Result updateRole(Role role) {

        return ResultUtil.success(service.updateRole(role),null);

    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @GetMapping(value = "/addRole")
    public Result addRole(Role role,String menus) {

        return ResultUtil.success(service.addRole(role,menus),null);
    }

    /**
     * 修改角色权限
     * @param role
     * @param ymenus   拥有的权限
     * @param nmenus    没有的权限
     * @return
     */
    @GetMapping(value = "/updateRoleMenu")
    public Result updateRomeMenu(Role role,@RequestParam(value = "ymenus") String ymenus,@RequestParam(value = "nmenus")String nmenus) {

        return ResultUtil.success(service.updateRomeMenu(role,ymenus,nmenus),null);
    }
}
