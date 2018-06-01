package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.Menu;
import com.flowyj.pcenter.domain.MenuList;
import com.flowyj.pcenter.mapper.MenuMapper;
import com.flowyj.pcenter.utils.BaseUtils;
import com.flowyj.pcenter.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/31 0031 10:32
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper mapper;

    public List<Menu> findAllMenu() {

        List<Menu> menuList = mapper.findAllMenu();
        List<Menu> backList = new ArrayList<>();
        if (CommonUtil.isNotEmpty(menuList)) {
            if (menuList.size() > 0) {

                if (menuList != null && menuList.size() > 0) {
                    backList = BaseUtils.getMenuList(menuList);
                }
            }
        }
        return backList;
    }
}
