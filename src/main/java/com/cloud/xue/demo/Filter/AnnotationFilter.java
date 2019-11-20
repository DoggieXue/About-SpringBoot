package com.cloud.xue.demo.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Program demo
 * @Title: AnnotationFilter
 * @Description: SpringBoot中，通过注解的方式添加过滤器
 * @Author: XueXiao
 * @Create: 2019-11-19 14:20:40
 */
@WebFilter( urlPatterns = "/areas/*",
            filterName = "annotationFilter",
            initParams = {
                @WebInitParam(name="paramName", value="paramValue")
            })
public class AnnotationFilter implements Filter {

    private final static Logger logger =LoggerFactory.getLogger(AnnotationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init method in AnnotationFilter is invoked !");
        String initParamValue = filterConfig.getInitParameter("paramName");
        logger.info("初始化参数值是={}",initParamValue);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter method in AnnotationFilter is invoked !");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        logger.info("---URL={}", request.getRequestURL());
        logger.info("---URI={}", request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("destroy method in AnnotationFilter is invoked !");
    }
}
