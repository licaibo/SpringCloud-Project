package com.licaibo.risk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 风控服务，提供钉钉通知
 * @author licaibo
 * @date 2022-04-19
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
public class RiskServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiskServerApplication.class,args);
    }
}
