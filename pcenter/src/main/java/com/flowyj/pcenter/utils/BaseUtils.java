package com.flowyj.pcenter.utils;

import com.flowyj.pcenter.domain.Menu;
import com.flowyj.pcenter.domain.MenuList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/31 0031 10:38
 */
public class BaseUtils {

    public static List<MenuList> getMenuList(List<Menu> menuList) {

        List<MenuList> backList = new ArrayList<>();
        for (int i=0;i<menuList.size();i++) {
            MenuList bean = new MenuList();
            Menu mi = menuList.get(i);
            if (mi.getParentCode() == 0) {
                List<MenuList> list = new ArrayList<>();
                for (int j=0;j<menuList.size();j++) {
                    Menu mj = menuList.get(j);
                    MenuList beanj = new MenuList();
                    if (mj.getParentCode() != 0) {
                        if (mi.getCode() == mj.getParentCode()) {
                            beanj.setGid(mj.getGid());
                            beanj.setMenuName(mj.getMenuName());
                            beanj.setIcon(mj.getIcon());
                            beanj.setUrl(mj.getUrl());
                            list.add(beanj);
                        }
                    }

                }
                bean.setGid(mi.getGid());
                bean.setMenuName(mi.getMenuName());
                bean.setIcon(mi.getIcon());
                bean.setUrl(mi.getUrl());
                bean.setMenuList(list);
                backList.add(bean);
            }

        }

        return backList;
    }
}
