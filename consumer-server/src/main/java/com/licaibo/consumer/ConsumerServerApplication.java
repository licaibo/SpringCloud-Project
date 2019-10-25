package com.licaibo.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by licaibo on 2017/9/30
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableFeignClients
public class ConsumerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class,args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//
//    @Bean
//    public Logger.Level feignLogger() {
//        return Logger.Level.FULL;
//    }
//
//    private static final int FIVE_SECONDS = 5000;
//
//    @Bean
//    public Request.Options options() {
//        return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
//    }
}
