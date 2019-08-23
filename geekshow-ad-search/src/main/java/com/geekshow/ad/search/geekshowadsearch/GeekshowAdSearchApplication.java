package com.geekshow.ad.search.geekshowadsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 广告搜索服务启动类
 */
@EnableFeignClients  //启动Feign 客户端，为了访问其他微服务
@EnableDiscoveryClient // 开启服务发现组件，在这里等同于 @EnableEurekaClient
@EnableHystrix // 开启hystrix 断路器
@EnableCircuitBreaker // 断路器
@EnableHystrixDashboard // 开启hystrix 监控
@SpringBootApplication
public class GeekshowAdSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekshowAdSearchApplication.class, args);
    }

    /**
     * 注册{@link RestTemplate}Bean
     * @return
     */
    @Bean
    @LoadBalanced
    //让RestTemplate在调用服务的时候，可以实现负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
