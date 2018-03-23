package com.jiemin.wages.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 16:42
 */
public interface StaffRepository extends JpaRepository<Staff, Long>{

    /**
     * 根据员工名称查找
     * @param staffName
     * @return
     */

    //Staff findByStaffName(String staffName);

}
