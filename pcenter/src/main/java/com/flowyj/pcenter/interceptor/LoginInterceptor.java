package com.flowyj.pcenter.interceptor;

import com.flowyj.pcenter.enums.ResultEnum;
import com.flowyj.pcenter.exception.PCenterException;
import com.flowyj.pcenter.service.LoginService;
import com.flowyj.pcenter.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Descript: 登陆拦截器
 * @Author: liuyingjie
 * @Date: create in 2017/12/28 0028 15:52
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService service;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("===========进入拦截器==============");
        String sessionId = httpServletRequest.getParameter("sessionId");
        //不拦截登陆相关操作
        if(httpServletRequest.getRequestURL().indexOf("login") != -1 && httpServletRequest.getRequestURL().indexOf("loginOut") == -1){
            return true;
        }
        //校验是否传了sessionId
        if(CommonUtil.isEmpty(sessionId)){
            throw new PCenterException(ResultEnum.EMPTY_SESSIONID);
        }
        //校验sessionId是否正确
        if(service.check(sessionId)){

            //校验是否敏感操作,删除数据之类
            if (httpServletRequest.getRequestURL().indexOf("delete") != -1) {

                //校验是否有用删除权限
                if(service.checkPermission(sessionId)) {
                    return true;
                } else {
                    throw new PCenterException(ResultEnum.NO_PERMISSION);
                }

            }
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
