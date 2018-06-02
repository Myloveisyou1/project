package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.Icon;
import com.flowyj.pcenter.domain.Menu;
import com.flowyj.pcenter.domain.MenuRole;
import com.flowyj.pcenter.mapper.MenuMapper;
import com.flowyj.pcenter.utils.BaseUtils;
import com.flowyj.pcenter.utils.CommonUtil;
import com.flowyj.pcenter.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 查询所有菜单
     * @return
     */
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

    /**
     * 查询所有图标
     * @return
     */
    public List<Icon> findIconList() {

        return mapper.findIconList();
    }

    /**
     * 添加图标
     * @param name
     * @param url
     * @return
     */
    public boolean addIcon(String name,String url) {

        Icon icon = new Icon();
        icon.setName(name);
        icon.setUrl(url);
        icon.setStatus(0);
        icon.setVersion(1l);
        icon.setCreateTime(DatesUtils.time());
        icon.setUpdateTime(DatesUtils.time());
        return mapper.addIcon(icon);
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public boolean addMenu(Menu menu) {

        Menu bean = mapper.findAllMenu().get(0);
        if (CommonUtil.isNotEmpty(menu.getParentCode())) {
            //添加子菜单
            menu.setCode(bean.getCode()+1);
        } else {
            menu.setParentCode(0);
            menu.setCode(bean.getCode()+1);
        }
        menu.setStatus(0);
        menu.setVersion(1l);
        menu.setCreateTime(DatesUtils.time());
        menu.setUpdateTime(DatesUtils.time());
        return mapper.addMenu(menu);
    }

    /**
     * 删除菜单
     * @param gid
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delMenu(Long gid) {

        Menu menu = mapper.findById(gid);

        //查询子类菜单
        List<Menu> cmenu = mapper.findMenuByParentCode(menu.getCode());
        if (CommonUtil.isNotEmpty(cmenu) && cmenu.size() > 0) {
            //删除子类的权限
            for (int i = 0; i < cmenu.size(); i++) {
                mapper.deleteMenuRoleByMenuId(cmenu.get(i).getGid());
            }
        }

        //1.删除角色菜单关联表========删除本身
        mapper.deleteMenuRoleByMenuId(gid);

        //2.删除菜单


        return mapper.deleteMenuByMenuId(gid,menu.getCode());
    }
}
