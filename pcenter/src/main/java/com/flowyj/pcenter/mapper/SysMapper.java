package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.SysVersion;
import com.flowyj.pcenter.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 18:02
 */
@Mapper
@Component
public interface SysMapper {

    @Insert("insert into sys_version (#{version})")
    @Lang(SimpleInsertLangDriver.class)
    boolean addVersion(SysVersion version);


    @Select("select gid,msg,version,update_time updateTime from sys_version")
    List<SysVersion> findSysVersion();
}
