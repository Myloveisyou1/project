package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.Consume;
import com.flowyj.pcenter.domain.common.Pages;
import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.mapper.ConsumeMapper;
import com.flowyj.pcenter.utils.BaseUtils;
import com.flowyj.pcenter.utils.CommonUtil;
import com.flowyj.pcenter.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/6 0006 10:37
 */
@Service
public class ConsumeService {

    @Autowired
    private ConsumeMapper mapper;

    /**
     * 查询消费记录
     * @return
     */
    public Map<String,Object> findConsume(Consume consume, Integer pageNumber, Integer pageSize) {

        Map<String,Object> map = new HashMap<>();
        Pages pages = BaseUtils.pages(pageNumber,pageSize);

        List<Consume> list = mapper.findConsume(consume, pages);
        if (list != null && list.size() > 0) {
            for (int i = 0;i < list.size();i++) {
                list.get(i).setConsumeTypeName(ResultEnum.getMsgByCode(list.get(i).getConsumeType()));
            }
        }

        int count = mapper.findConsumeCount(consume);
        pages = BaseUtils.pagesResult(pages,count);
        map.put("list",list);
        map.put("page",pages);

        return map;
    }

    /**
     * 添加消费记录
     * @param consume
     * @return
     */
    public boolean addConsume(Consume consume) {

        if (CommonUtil.isNotEmpty(consume)) {
            consume.setVersion(1l);
            consume.setStatus(0);
            consume.setCreateTime(DatesUtils.time());
            consume.setUpdateTime(DatesUtils.time());
            return mapper.addConsume(consume);
        } else {
            return false;
        }

    }
}
