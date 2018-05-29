package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.Role;
import com.flowyj.pcenter.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/29 0029 17:38
 */
@Service
public class RoleService {


    @Autowired
    private RoleMapper mapper;

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAllRole() {


        return mapper.findAllRole();
    }
}
