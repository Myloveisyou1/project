package com.jiemin.wages.interceptor;

import com.jiemin.wages.enums.ResultEnum;
import com.jiemin.wages.exception.FarmException;
//import com.jiemin.wages.service.LoginService;
import com.jiemin.wages.utils.CommonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Descript: 登陆拦截器
 * @Author: liuyingjie
 * @Date: create in 2017/12/28 0028 15:52
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    //private LoginService service;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("===========进入拦截器==============");
//        HandlerMethod method = (HandlerMethod)o;
//        method.getMethod();
//        method.getMethodParameters();
        String sessionId = httpServletRequest.getParameter("sessionId");
        //不拦截登陆相关操作
        if(httpServletRequest.getRequestURL().indexOf("login") != -1 && httpServletRequest.getRequestURL().indexOf("loginOut") == -1){
            return true;
        }
        //校验是否传了sessionId
        if(CommonUtil.isEmpty(sessionId)){
            throw new FarmException(ResultEnum.EMPTY_SESSIONID);
        }
        //校验sessionId是否正确
        /*if(service.check(sessionId)){
            return true;
        }*/
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        log.info(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
        if(httpServletResponse.getStatus()==500){
            modelAndView.setViewName("/errorpage/500");
        }else if(httpServletResponse.getStatus()==404){
            modelAndView.setViewName("/errorpage/404");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
