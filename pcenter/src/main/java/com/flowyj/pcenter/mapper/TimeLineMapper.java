package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.TimeLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descript: 时间轴
 * @Author: liuyingjie
 * @Date: create in 2018/5/28 0028 15:44
 */
@Component
@Mapper
public interface TimeLineMapper {


    /**
     * 查询时间轴
     * @param userName
     * @return
     */
    @Select("select gid,icon,content,create_time createTime,status from time_line where create_user = #{userName} order by gid desc")
    List<TimeLine> queryTimeLineList(@Param(value = "userName") String userName);
}
