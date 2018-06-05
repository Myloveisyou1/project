package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.SalaryType;
import com.flowyj.pcenter.mapper.SalaryTypeMapper;
import com.flowyj.pcenter.utils.CommonUtil;
import com.flowyj.pcenter.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 17:42
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryTypeMapper mapper;

    /**
     * 查询工资配置项
     * @param salaryType
     * @return
     */
    public List<SalaryType> findSalaryType(SalaryType salaryType) {

        if (CommonUtil.isNotEmpty(salaryType.getSType())) {
            if (salaryType.getSType() == -1) {
                salaryType.setSType(null);
            }
            if (salaryType.getStatus() == -1) {
                salaryType.setStatus(null);
            }
        }
        List<SalaryType> list = mapper.findSalaryType(salaryType);

        return list;
    }

    /**
     * 添加工资消费类型
     * @param salaryType
     * @return
     */
    public boolean addSalaryType(SalaryType salaryType) {

        salaryType.setVersion(1l);
        salaryType.setCreateTime(DatesUtils.time());
        salaryType.setUpdateTime(DatesUtils.time());
        salaryType.setStatus(0);
        return mapper.addSalaryType(salaryType);
    }

    /**
     * 删除
     * @param gid
     * @return
     */
    public boolean delSalaryType(Long gid) {

        return mapper.delSalaryType(gid);
    }

    /**
     * 根据id查询
     * @param gid
     * @return
     */
    public SalaryType findById(Long gid) {

        return mapper.findById(gid);
    }

    /**
     * 编辑
     * @param salaryType
     * @return
     */
    public boolean updateSalaryType(SalaryType salaryType) {

        SalaryType bean = findById(salaryType.getGid());
        if (CommonUtil.isNotEmpty(salaryType.getSType())) {
            bean.setSType(salaryType.getSType());
        }
        if (CommonUtil.isNotEmpty(salaryType.getSName())) {
            bean.setSName(salaryType.getSName());
        }
        if (CommonUtil.isNotEmpty(salaryType.getSDeductionsType())) {
            bean.setSDeductionsType(salaryType.getSDeductionsType());
        }
        if (CommonUtil.isNotEmpty(salaryType.getSDeductionsValue())) {
            bean.setSDeductionsValue(salaryType.getSDeductionsValue());
        }
        if (CommonUtil.isNotEmpty(salaryType.getSOperationType())) {
            bean.setSOperationType(salaryType.getSOperationType());
        }
        if (CommonUtil.isNotEmpty(salaryType.getStatus())) {
            bean.setStatus(salaryType.getStatus());
        }

        bean.setVersion(bean.getVersion()+1);
        bean.setUpdateTime(DatesUtils.time());

        return mapper.updateSalaryType(bean);
    }
}
