package com.jiemin.wages.service;

import com.jiemin.wages.domain.SalaryType;
import com.jiemin.wages.domain.SalaryTypeRepository;
import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.domain.common.Pages;
import com.jiemin.wages.domain.common.Result;
import com.jiemin.wages.enums.ResultEnum;
import com.jiemin.wages.exception.FarmException;
import com.jiemin.wages.mapper.SalaryTypeMapper;
import com.jiemin.wages.utils.CommonUtil;
import com.jiemin.wages.utils.PageUtils;
import com.jiemin.wages.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 16:19
 */
@Service
public class SalaryTypeService {

    @Autowired
    private SalaryTypeRepository salaryTypeRepository;

    @Autowired
    private SalaryTypeMapper salaryTypeMapper;

    /**
     * 添加工资类型
     * @param salaryType
     * @return
     */
    public Result saveSalaryType(SalaryType salaryType) {

        if(CommonUtil.isNotEmpty(salaryType)) {
            salaryTypeMapper.insertStaff(salaryType);
            return ResultUtil.success(salaryType,null);
        } else {
            return ResultUtil.error(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
        }
    }

    /**
     * 删除信息
     * @param gid
     * @return
     */
    public Result delByGid(long gid) {

        try{
            SalaryType salaryType = salaryTypeMapper.getOne(gid);
            System.out.println(salaryType.getGid()+"----------------------");
            if(CommonUtil.isNotEmpty(salaryType) && CommonUtil.isNotEmpty(salaryType.getGid())) {
                salaryTypeMapper.delByGid(salaryType.getGid());
                return ResultUtil.success();
            } else {
                return ResultUtil.error(404,"删除失败,信息不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new FarmException(ResultEnum.ILLEGAL_OPERATION);
        }
    }

    /**
     * 修改信息
     * @param salaryType
     * @return
     */
    public Result updateSalaryType(SalaryType salaryType) {

        int ret = salaryTypeMapper.updateSalaryType(salaryType);
        if (ret > 0) {
            return ResultUtil.success();
        } else {
            throw new FarmException(ResultEnum.ILLEGAL_OPERATION);
        }
    }

    /**
     *  根据员工姓名分页查询
     * @param pageNumber
     * @param pageSize
     * @param typeName
     * @return
     */
    public Result findSalaryTypeByPage(Integer pageNumber, Integer pageSize, String typeName) {

        Page<SalaryType> salaryType;
        Sort sort = new Sort(Sort.Direction.DESC, "gid");
        Pageable pageable = new PageRequest((pageNumber-1),pageSize,sort);

        if(CommonUtil.isEmpty(typeName)) {
            salaryType = salaryTypeRepository.findAll(pageable);
        } else {
            salaryType = salaryTypeRepository.findByTypeNameStartingWith(typeName,pageable);
        }
        Pages pages = PageUtils.detail(pageNumber,pageSize,salaryType.isFirst(),salaryType.isLast(),salaryType.getTotalPages(),salaryType.getTotalElements());

        return ResultUtil.success(salaryType.getContent(),pages);

    }
}
