package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.TimeLine;
import com.flowyj.pcenter.mapper.TimeLineMapper;
import com.flowyj.pcenter.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript: 时间轴
 * @Author: liuyingjie
 * @Date: create in 2018/5/28 0028 15:42
 */
@Service
public class TimeLineService {

    @Autowired
    private TimeLineMapper timeLineMapper;

    /**
     * 查询当前登录人的时间轴
     * @param userName
     * @return
     */
    public List<TimeLine> queryTimeLineList(String userName) {

        List<TimeLine> list = timeLineMapper.queryTimeLineList(userName);

        //处理数据
        if(list != null && list.size() > 0) {
            for(int i=list.size()-1;i>=0;i--) {
                if (i < list.size()) {
                    TimeLine ti = list.get(i);
                    List<TimeLine> list2 = new ArrayList<>();
                    for(int j=list.size()-1;j>=0;j--) {
                        TimeLine tj = list.get(j);
                        try {
                            if(DatesUtils.formatDate(ti.getCreateTime(),"yyyy-MM-dd").getTime() == DatesUtils.formatDate(tj.getCreateTime(),"yyyy-MM-dd").getTime()) {
                                list2.add(tj);
                                list.remove(tj);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    ti.setList(list2);
                }

            }
        }

        return list;

    }
}
