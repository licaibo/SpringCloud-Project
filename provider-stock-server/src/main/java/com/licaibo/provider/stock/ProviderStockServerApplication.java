package com.licaibo.provider.stock;

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
@MapperScan("com.licaibo.provider.stock.dao")
@ComponentScan({"com.licaibo.provider.stock","com.licaibo.common","com.licaibo.framework"})
@EnableFeignClients(basePackages = {"com.licaibo.provider.stock", "com.licaibo.common","com.licaibo.framework"})
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderStockServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStockServerApplication.class,args);
    }
}
