package com.jiemin.wages.mapper;

import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.utils.SimpleInsertLangDriver;
import com.jiemin.wages.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 15:48
 */
@Mapper
@Component
public interface StaffMapper {

    @Update("update staff (#{staff}) where gid=${gid}")
    @Lang(SimpleUpdateLangDriver.class)
    int updateStaff(Staff staff);

    @Insert("insert into staff (#{staff})")
    @Lang(SimpleInsertLangDriver.class)
    int insertStaff(Staff staff);

    @Delete("delete from staff where gid=${gid}")
    int delByGid(@Param("gid") long gid);

    @Select("select * from staff where gid=${gid}")
    Staff getOne(@Param("gid") long gid);
}
