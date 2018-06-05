package com.flowyj.pcenter.service;

import com.flowyj.pcenter.domain.SysVersion;
import com.flowyj.pcenter.mapper.SysMapper;
import com.flowyj.pcenter.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/4 0004 18:00
 */
@Service
public class SysService {

    @Autowired
    private SysMapper mapper;

    public boolean addVersion(SysVersion version) {

        version.setUpdateTime(DatesUtils.time());
        version.setVersion("P_"+DatesUtils.getToday().replaceAll("-","")+"_"+version.getVersion());

        return mapper.addVersion(version);

    }

    public List<SysVersion> findSysVersion() {

        return mapper.findSysVersion();
    }
}
