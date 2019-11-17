package com.cloud.xue.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//配置MyBatis mapper的扫描路径
@MapperScan("com.cloud.xue.demo.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUserName;

    /**
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDateSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);

        dataSource.setJdbcUrl(jdbcUrl);

        dataSource.setUser(jdbcUserName);

        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
