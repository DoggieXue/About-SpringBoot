package com.cloud.xue.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version: v1.0.0
 * Created by xuexiao on 2018-06-03 09:21:14.
 */
@Component
@ConfigurationProperties(prefix = "config")
public class DemoConfig {
    private String ip;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip=ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port=port;
    }

}
