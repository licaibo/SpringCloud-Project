package com.licaibo.provider.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by licaibo on 2017/9/30
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.licaibo.provider.order.dao")
@ComponentScan({"com.licaibo.provider.order","com.licaibo.common","com.licaibo.framework"})
@EnableFeignClients(basePackages = {"com.licaibo.provider.order", "com.licaibo.common","com.licaibo.framework"})
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderOrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderServerApplication.class,args);
    }
}
