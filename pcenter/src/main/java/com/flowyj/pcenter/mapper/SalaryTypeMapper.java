package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.SalaryType;
import com.flowyj.pcenter.provider.BaseProvider;
import com.flowyj.pcenter.utils.SimpleInsertLangDriver;
import com.flowyj.pcenter.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/5 0005 11:42
 */
@Mapper
@Component
public interface SalaryTypeMapper {


    @SelectProvider(type = BaseProvider.class,method = "findSalaryType")
    List<SalaryType> findSalaryType(SalaryType salaryType);

    @Insert("insert into salary_type (#{salaryType})")
    @Lang(SimpleInsertLangDriver.class)
    boolean addSalaryType(SalaryType salaryType);

    @Delete("delete from salary_type where gid = #{gid}")
    boolean delSalaryType(Long gid);

    @Select("select gid,s_type sType,s_name sName,s_deductions_type sDeductionsType," +
            "s_deductions_value sDeductionsValue,s_operation_type sOperationType,version,create_time createTime,update_time updateTime,status from salary_type where gid=#{gid}")
    SalaryType findById(Long gid);

    @Update("update salary_type (#{bean}) where gid = #{gid}")
    @Lang(SimpleUpdateLangDriver.class)
    boolean updateSalaryType(SalaryType bean);
}
