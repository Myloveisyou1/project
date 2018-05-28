package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.Logs;
import com.flowyj.pcenter.utils.SimpleInsertLangDriver;
import com.flowyj.pcenter.utils.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/14 0014 15:33
 */
@Component
@Mapper
public interface LogsMapper {

    @Insert("insert into logs (#{logs})")
    @Lang(SimpleInsertLangDriver.class)
    @Options(useGeneratedKeys = true,keyProperty = "gid",keyColumn = "gid")
    void optSaveLogs(Logs logs);

    @Update("update logs (#{logs}) where gid = #{gid}")
    @Lang(SimpleUpdateLangDriver.class)
    void optUpdateLogs(Logs logs);

    @Select("select gid,url,method,ip,class_method classMethod,args,start_time startTime,end_time endTime,time,rep_data repData from logs order by gid desc limit #{start},#{end}")
    List<Logs> pagingQueryLogs(@Param(value = "start") Integer start,@Param(value = "end") Integer end);


    @Select("select count(gid) count from logs")
    int pagingQueryLogsCount();
}
