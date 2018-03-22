package com.jiemin.wages.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class HttpAspect {

    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.jiemin.wages.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("===========开始请求"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"============");
        log.info("===========请求时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"==========================");
        //获取url
        log.info("url={}",request.getRequestURL());

        //获取method
        log.info("method={}",request.getMethod());

        //获取ip
        log.info("ip={}",request.getRemoteAddr());

        //获取类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //获取类参数
        log.info("args={}",joinPoint.getArgs());

        //保存请求相关的信息

    }
    @After("log()")
    public void doAfter(){
        log.info("=============结束请求时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"======================");
    }
    /**
     * 获取返回的结果集
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn( Object object){
        log.info("response={}",object.toString());
    }

}
