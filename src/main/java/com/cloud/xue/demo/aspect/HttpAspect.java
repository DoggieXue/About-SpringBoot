package com.cloud.xue.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Program demo
 * @Title: HttpAspect
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 21:11:16
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.cloud.xue.demo.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL={}", request.getRequestURL());

        logger.info("METHOD={}", request.getMethod());

        logger.info("IP={}", request.getRemoteHost());

        logger.info("CLASS_METHOD={}", joinPoint.getSignature().getDeclaringType() + "#" + joinPoint.getSignature().getName());

        logger.info("ARGS={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("doAfter={}", "=========================");
    }

    @AfterReturning(returning="object", pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("resp={}", object.toString());
    }
}
