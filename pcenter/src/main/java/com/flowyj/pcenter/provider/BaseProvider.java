package com.flowyj.pcenter.provider;

import com.flowyj.pcenter.PcenterApplication;
import com.flowyj.pcenter.domain.Consume;
import com.flowyj.pcenter.domain.SalaryType;
import com.flowyj.pcenter.domain.common.Pages;
import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.exception.PCenterException;
import com.flowyj.pcenter.utils.CommonUtil;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/30 0030 11:46
 */
public class BaseProvider {

    /**
     * 用户相关操作===============================================
     * @param userName
     * @return
     */

    public String findAllUser(String userName) {

        StringBuffer sql = new StringBuffer("select gid,user_name userName,password,tel,email,role_id roleId,role_name roleName,create_time createTime,update_time updateTime,login_time loginTime,status,version from user where 1=1");
        if (CommonUtil.isNotEmpty(userName)) {
            sql.append(" AND user_name like '%"+userName+"%'");
        }

        sql.append(" order by gid desc");

        return sql.toString();
    }



    /**
     * 日志相关操作===============================================
     * @param
     * @return
     */

    public String pagingQueryLogs(Integer start,Integer end,String startTime,String endTime) {

        StringBuffer sql = new StringBuffer("select gid,url,method,ip,class_method classMethod,args,start_time startTime,end_time endTime,time,rep_data repData from logs where 1=1");

        if (CommonUtil.isNotEmpty(startTime)) {
            sql.append(" AND start_time >= '"+startTime+" 00:00:00'");
        }
        if (CommonUtil.isNotEmpty(endTime)) {
            sql.append(" AND end_time <= '"+endTime+" 23:59:59'");
        }
        sql.append(" order by gid desc limit "+start+","+end);

        return sql.toString();
    }

    public String pagingQueryLogsCount(String startTime,String endTime) {

        StringBuffer sql = new StringBuffer("select count(gid) count from logs where 1=1");

        if (CommonUtil.isNotEmpty(startTime)) {
            sql.append(" AND start_time >= '"+startTime+" 00:00:00'");
        }
        if (CommonUtil.isNotEmpty(endTime)) {
            sql.append(" AND end_time <= '"+endTime+" 23:59:59'");
        }

        return sql.toString();
    }


    /**
     * ====================================薪资扣费(消费)项配置=============================================================
     */

    public String findSalaryType(SalaryType salaryType) {

        StringBuffer sql = new StringBuffer("select gid,s_type sType,s_name sName,s_deductions_type sDeductionsType," +
                "s_deductions_value sDeductionsValue,s_operation_type sOperationType,version,create_time createTime,update_time updateTime,status from salary_type where 1=1");
        if (CommonUtil.isNotEmpty(salaryType)) {
            if (CommonUtil.isNotEmpty(salaryType.getSType())) {
                sql.append(" and s_type = "+salaryType.getSType());
            }
            if (CommonUtil.isNotEmpty(salaryType.getSName())) {
                sql.append(" and s_name like '%"+salaryType.getSName()+"%'");
            }
            if (CommonUtil.isNotEmpty(salaryType.getStatus())) {
                sql.append(" and status = "+salaryType.getStatus());
            }
        }
        return sql.toString();
    }

    /**
     * ====================================消费记录=============================================================
     */
    public String findConsume(Consume consume,Pages pages) {

        StringBuffer sql = new StringBuffer("select gid,consume_type consumeType,consume_money consumeMoney,consume_remark consumeRemark," +
                        "version,create_time createTime,update_time updateTime,status from consume where 1=1");
        if (CommonUtil.isNotEmpty(consume)) {
            if (CommonUtil.isNotEmpty(consume.getConsumeType())) {
                if (consume.getConsumeType() != -1) {
                    sql.append(" and consume_type = "+consume.getConsumeType());
                }
            }
            if (CommonUtil.isNotEmpty(consume.getStart())) {
                sql.append(" and create_time >= "+consume.getStart()+" 00:00:00");
            }
            if (CommonUtil.isNotEmpty(consume.getEnd())) {
                sql.append(" and create_time <= "+consume.getEnd()+" 23:59:59");
            }
        }
        sql.append(" order by consume_type,gid desc");

        if (CommonUtil.isNotEmpty(pages)) {
            if (CommonUtil.isNotEmpty(pages.getPageNumber()) && CommonUtil.isNotEmpty(pages.getPageSize())) {
                sql.append(" limit "+(pages.getPageNumber()-1)*pages.getPageSize()+","+pages.getPageSize());
            } else {
                throw new PCenterException(ResultEnum.EMPTY_ERROR);
            }
        }

        return sql.toString();
    }

    public String findConsumeCount(Consume consume) {

        StringBuffer sql = new StringBuffer("select count(gid) from consume where 1=1");

        if (CommonUtil.isNotEmpty(consume)) {
            if (CommonUtil.isNotEmpty(consume.getConsumeType())) {
                if (consume.getConsumeType() != -1) {
                    sql.append(" and consume_type = "+consume.getConsumeType());
                }
            }
            if (CommonUtil.isNotEmpty(consume.getStart())) {
                sql.append(" and create_time >= "+consume.getStart()+" 00:00:00");
            }
            if (CommonUtil.isNotEmpty(consume.getEnd())) {
                sql.append(" and create_time <= "+consume.getEnd()+" 23:59:59");
            }
        }

        return sql.toString();
    }
}
