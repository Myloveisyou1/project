package com.jiemin.wages.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 16:18
 */
public interface SalaryTypeRepository extends JpaRepository<SalaryType,Long>{

    Page<SalaryType> findByTypeNameStartingWith(String typeName, Pageable pageable);
}
