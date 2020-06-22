package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import util.IdWorker;

@SpringBootApplication//@CrossOrigin //解决微服务之间条用的跨域问题 在controller 访问入口 里面填写
@EnableEurekaClient

public class BaseAppliaction {

    public static void main(String[] args) {
        SpringApplication.run(BaseAppliaction.class);
    }

    @Bean//让返回值的方法在容器中 加一个bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }



}
