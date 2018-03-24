package com.jiemin.wages.mapper;

import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

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
}