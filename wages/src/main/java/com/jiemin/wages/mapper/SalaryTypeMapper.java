package com.jiemin.wages.mapper;

import com.jiemin.wages.domain.SalaryType;
import com.jiemin.wages.utils.SimpleInsertLangDriver;
import com.jiemin.wages.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 16:42
 */
@Mapper
@Component
public interface SalaryTypeMapper {

    @Update("update salary_type (#{salaryType}) where gid=${gid}")
    @Lang(SimpleUpdateLangDriver.class)
    int updateSalaryType(SalaryType salaryType);

    @Insert("insert into salary_type (#{salaryType})")
    @Lang(SimpleInsertLangDriver.class)
    int insertStaff(SalaryType salaryType);

    @Delete("delete from salary_type where gid=${gid}")
    int delByGid(@Param("gid") long gid);

    @Select("select * from salary_type where gid=${gid}")
    SalaryType getOne(@Param("gid") long gid);
}
