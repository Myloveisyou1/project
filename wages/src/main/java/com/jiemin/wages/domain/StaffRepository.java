package com.jiemin.wages.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/23 0023 16:42
 */
//@Component
public interface StaffRepository{

    /**
     * 根据员工名称查找
     * @param userName
     * @return
     */

    Page<Staff> findByUserNameStartingWith(String userName, Pageable pageable);


}
