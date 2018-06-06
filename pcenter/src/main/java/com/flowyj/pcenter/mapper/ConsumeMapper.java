package com.flowyj.pcenter.mapper;

import com.flowyj.pcenter.domain.Consume;
import com.flowyj.pcenter.domain.common.Pages;
import com.flowyj.pcenter.provider.BaseProvider;
import com.flowyj.pcenter.utils.SimpleInsertLangDriver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/6/6 0006 10:24
 */
@Mapper
@Component
public interface ConsumeMapper {

    @SelectProvider(type = BaseProvider.class,method = "findConsume")
    List<Consume> findConsume(Consume consume,Pages pages);

    @Insert("insert into consume (#{consume})")
    @Lang(SimpleInsertLangDriver.class)
    boolean addConsume(Consume consume);

    @SelectProvider(type = BaseProvider.class,method = "findConsumeCount")
    int findConsumeCount(Consume consume);
}
