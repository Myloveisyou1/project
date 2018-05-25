package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/25 0025 15:37
 */
@Component
@Mapper
public interface MenuMapper {


    @Select("select m.gid,m.icon,m.menu_name menuName,m.url,m.parent_code parentCode,m.`code`,m.belong,m.version,m.create_time createTime,m.update_time updateTime,m.`status` " +
            "from menu m inner join menu_role r on m.gid=r.menu_id and m.status=0 and r.role_id = #{roleId}")
    List<Menu> findMenuByRole(Long roleId);
}
