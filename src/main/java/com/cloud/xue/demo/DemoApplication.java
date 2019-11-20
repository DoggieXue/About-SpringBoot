package com.cloud.xue.demo;

import com.cloud.xue.demo.Filter.RegisterByCodeFilter;
import com.cloud.xue.demo.config.DemoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//通过该注解添加Filter
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
	    //启动嵌入式的Tomcat 并初始化Spring环境及各Spring组件
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registerFilterByCode(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new RegisterByCodeFilter());
		filterRegistrationBean.setName("registionFilter");

		filterRegistrationBean.addUrlPatterns("/areas/*");
		filterRegistrationBean.addInitParameter("paramName","paramValues");
		filterRegistrationBean.setOrder(0);//指定Fiter被执行的顺序
		return filterRegistrationBean;
	}
}
