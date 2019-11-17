package com.cloud.xue.demo;

import com.cloud.xue.demo.config.DemoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	    //启动嵌入式的Tomcat 并初始化Spring环境及各Spring组件
		SpringApplication.run(DemoApplication.class, args);
	}
}
