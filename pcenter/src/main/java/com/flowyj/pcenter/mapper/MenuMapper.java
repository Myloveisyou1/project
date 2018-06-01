package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.Menu;
import com.flowyj.pcenter.domain.MenuRole;
import com.flowyj.pcenter.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:37
 */
@Component
@Mapper
public interface MenuMapper {


    @Select("select m.gid,m.icon,m.menu_name menuName,m.url,m.parent_code parentCode,m.`code`,m.belong,m.version,m.create_time createTime,m.update_time updateTime,m.`status`,p.project_name projectName " +
            "from menu m inner join menu_role r on m.gid=r.menu_id inner JOIN project p on m.belong=p.gid and m.status=0 and r.role_id = #{roleId} order by m.gid")
    List<Menu> findMenuByRole(Long roleId);

    @Select("select m.gid,m.icon,m.menu_name menuName,m.url,m.parent_code parentCode,m.`code`,m.belong,m.version,m.create_time createTime,m.update_time updateTime,m.`status`,p.project_name projectName " +
            "from menu m left join project p on m.belong=p.gid order by gid desc")
    List<Menu> findAllMenu();

    @Insert("insert into menu_role (#{menuRole})")
    @Lang(SimpleInsertLangDriver.class)
    @Options(useGeneratedKeys = true,keyProperty = "gid",keyColumn = "gid")
    void addMenuRole(MenuRole menuRole);

    @Select("select gid,role_id roleId,menu_id menuId,version,create_time createTime,update_time updateTime,status from menu_role where role_id=#{roleId} and menu_id=#{menuId}")
    MenuRole findInfoByRoleAndMenu(@Param(value = "roleId") Long roleId, @Param(value = "menuId") Long menuId);

    @Delete("delete from menu_role where gid = #{gid}")
    boolean deleteMenuRole(MenuRole menuRole);

    @Update("update menu set status = #{status} where belong = #{belong}")
    boolean updateMenuByProject(Menu menu);

    @Delete("delete from menu_role where role_id = #{roleId}")
    boolean deleteMenuRoleByRoleId(@Param(value = "roleId") Long roleId);

    /**
     * 根据项目删除菜单
     * @param gid
     * @return
     */
    @Delete("delete from menu where belong = #{gid}")
    boolean deleteMenuByProject(@Param(value = "gid") Long gid);
}
