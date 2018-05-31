package com.flowyj.pcenter.service;

import com.alibaba.fastjson.JSONObject;
import com.flowyj.pcenter.domain.Menu;
import com.flowyj.pcenter.domain.MenuList;
import com.flowyj.pcenter.domain.Role;
import com.flowyj.pcenter.domain.User;
import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.exception.PCenterException;
import com.flowyj.pcenter.mapper.MenuMapper;
import com.flowyj.pcenter.mapper.RoleMapper;
import com.flowyj.pcenter.mapper.UserMapper;
import com.flowyj.pcenter.utils.BaseUtils;
import com.flowyj.pcenter.utils.CommonUtil;
import com.flowyj.pcenter.utils.DatesUtils;
import com.flowyj.pcenter.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Descript:
 * @Author: liuyingjie
 * @Date: create in 2018/5/24 0024 16:13
 */
@Service
public class LoginService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Map<String,Object> findUser(String userName, String password) {

        //加密
        password = MD5Util.getMD5(userName+password);

        User user = mapper.findByUserNameAndPassword(userName,password);
        Map<String,Object> map = new HashMap<>();
        String sessionId = "";
        if(mapper.findByUserName(userName) != null){
            if(user != null){
                if (user.getStatus() == 0) {
                    //先判断原来登陆是否失效
                    if(stringRedisTemplate.hasKey("sessionId"+userName)){
                        sessionId = stringRedisTemplate.opsForValue().get("sessionId"+userName);
                    } else {

                        //保存session到redis
                        sessionId = MD5Util.getMD5(new Date().toString());
                    }
                    stringRedisTemplate.opsForValue().set("sessionId"+userName,sessionId);
                    stringRedisTemplate.opsForValue().set(sessionId, JSONObject.toJSONString(user),1800, TimeUnit.SECONDS);
                    map.put("sessionId",sessionId);
                    map.put("user",user);

                    //获取权限信息
                    Long roleId = user.getRoleId();
                    //判断角色是否可用
                    Role role = roleMapper.findById(roleId);
                    if (CommonUtil.isNotEmpty(role)) {
                        if (role.getStatus() == 1) {
                            throw new PCenterException(ResultEnum.ROLE_DISABLED);
                        }
                    }
                    List<Menu> menuList = menuMapper.findMenuByRole(roleId);
                    //最终返回的权限
                    List<MenuList> backList = new ArrayList<>();
                    if (menuList != null && menuList.size() > 0) {
                        backList = BaseUtils.getMenuList(menuList);
                    }
                    map.put("menu",backList);
                    //修改登录时间
                    user.setLoginTime(DatesUtils.time());
                    mapper.optUpdateUser(user);

                    return map;
                } else {
                    throw new PCenterException(ResultEnum.USER_DISABLED);
                }

            }else{
                throw new PCenterException(ResultEnum.ERROR_PASSWORD);
            }
        }else{
            throw  new PCenterException(ResultEnum.UNKNOW_ACCOUNT);
        }
    }

    /**
     * 校验登陆
     * @param sessionId
     * @return
     */
    public boolean check(String sessionId) {

        boolean flag = stringRedisTemplate.hasKey(sessionId);
        if(flag){
            //重新设置session有效期
            String str = stringRedisTemplate.opsForValue().get(sessionId);
            stringRedisTemplate.opsForValue().set(sessionId, str,1800, TimeUnit.SECONDS);
        }else{
            throw new PCenterException(ResultEnum.NOT_LOGIN);
        }
        return flag;
    }

    /**
     * 退出登录
     * @param sessionId
     * @return
     */
    public boolean loginOut(String sessionId) {

        stringRedisTemplate.delete(sessionId);
        stringRedisTemplate.delete("sessionId");
        return true;
    }
}
