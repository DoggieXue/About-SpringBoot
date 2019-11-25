package com.cloud.xue.demo;

import com.cloud.xue.demo.Filter.RegisterByCodeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
//通过该注解添加Filter
//@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
	    //启动嵌入式的Tomcat 并初始化Spring环境及各Spring组件
		SpringApplication.run(DemoApplication.class, args);
	}

	//@Bean
	public FilterRegistrationBean registerFilterByCode(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new RegisterByCodeFilter());
		filterRegistrationBean.setName("registionFilter");

		filterRegistrationBean.addUrlPatterns("/areas/*");
		filterRegistrationBean.addInitParameter("paramName","paramValues");
		filterRegistrationBean.setOrder(1);//指定Fiter被执行的顺序
		return filterRegistrationBean;
	}
}
