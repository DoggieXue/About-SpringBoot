package com.cloud.xue.demo.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Program demo
 * @Title: RegisterByCodeFilter
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-20 12:51:10
 */
public class RegisterByCodeFilter implements Filter {

    private final static Logger logger =LoggerFactory.getLogger(RegisterByCodeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init method in RegisterByCodeFilter is invoked !");
        String initParamValue = filterConfig.getInitParameter("paramName");
        logger.info("初始化参数值是={}",initParamValue);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter method in RegisterByCodeFilter is invoked !");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        logger.info("---URL={}", request.getRequestURL());
        logger.info("---URI={}", request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("destroy method in RegisterByCodeFilter is invoked !");
    }
}
