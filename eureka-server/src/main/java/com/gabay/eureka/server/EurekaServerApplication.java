package com.gabay.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 开启 Eureka 服务端
@SpringBootApplication
public class EurekaServerApplication {

    public static void main (String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
