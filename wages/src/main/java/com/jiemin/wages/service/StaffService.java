package com.jiemin.wages.service;

import com.jiemin.wages.domain.Staff;
import com.jiemin.wages.domain.common.Pages;
import com.jiemin.wages.domain.common.Result;
import com.jiemin.wages.enums.ResultEnum;
import com.jiemin.wages.exception.FarmException;
import com.jiemin.wages.mapper.StaffMapper;
import com.jiemin.wages.utils.CommonUtil;
import com.jiemin.wages.utils.DatesUtils;
import com.jiemin.wages.utils.PageUtils;
import com.jiemin.wages.utils.ResultUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Descript: 员工信息维护类
 * @Author: liuyingjie
 * @Date: create in 2018/3/24 0024 14:19
 */
@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;


    public Result addStaff(Staff staff) {

        if(CommonUtil.isNotEmpty(staff)) {
            staff.setCreateTime(new DatesUtils().time());
            staffMapper.insertStaff(staff);
            return ResultUtil.success(staff,null);
        } else {
            return ResultUtil.error(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
        }
    }

    /**
     *  根据员工姓名分页查询
     * @param pageNumber
     * @param pageSize
     * @param userName
     * @return
     */
    public Result findStaffByPage(Integer pageNumber, Integer pageSize, String userName) {

        /*Page<Staff> staff;
        Sort sort = new Sort(Sort.Direction.DESC, "gid");
        Pageable pageable = new PageRequest((pageNumber-1),pageSize,sort);

        if(CommonUtil.isEmpty(userName)) {
            staff = staffRepository.findAll(pageable);
        } else {
            staff = staffRepository.findByUserNameStartingWith(userName,pageable);
        }*/
        List<Staff> staffList = staffMapper.queryPagingStaff(userName,pageNumber,pageSize);
        if(CommonUtil.isNotEmpty(staffList)) {
            for(int i=0;i<staffList.size();i++) {
                Staff staff = staffList.get(i);
                if (CommonUtil.isNotEmpty(staff.getUserSex())) {
                    staff.setSex(staff.getUserSex()==ResultEnum.MAN.getCode()?ResultEnum.MAN.getMsg():ResultEnum.WOMEN.getMsg());
                }
            }
        }
        int count = staffMapper.queryCountStaff(userName);
        Pages pages = PageUtils.detail(pageNumber,pageSize,count);

        return ResultUtil.success(staffList,pages);

    }

    /**
     * 删除信息
     * @param gid
     * @return
     */
    public Result delByGid(long gid) {

        try{
            Staff staff = staffMapper.getOne(gid);
            System.out.println(staff.getGid()+"----------------------");
            if(CommonUtil.isNotEmpty(staff) && CommonUtil.isNotEmpty(staff.getGid())) {
                staffMapper.delByGid(staff.getGid());
                return ResultUtil.success();
            } else {
                return ResultUtil.error(404,"删除失败,员工不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new FarmException(ResultEnum.ILLEGAL_OPERATION);
        }
    }

    /**
     * 修改信息
     * @param staff
     * @return
     */
    public Result updateStaff(Staff staff) {

        int ret = staffMapper.updateStaff(staff);
        if (ret > 0) {
            return ResultUtil.success();
        } else {
            throw new FarmException(ResultEnum.ILLEGAL_OPERATION);
        }
    }

}
