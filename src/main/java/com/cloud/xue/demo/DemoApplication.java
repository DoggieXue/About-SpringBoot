package com.cloud.xue.demo;

import com.cloud.xue.demo.Filter.RegisterByCodeFilter;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.AbstractCollection;

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

	//为了解决上传文件大于10M出现连接重置的问题。此异常内容自定义的全局异常类也捕捉不到
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatEmbedded(){
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)){
				((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});


		return tomcat;
	}
}
