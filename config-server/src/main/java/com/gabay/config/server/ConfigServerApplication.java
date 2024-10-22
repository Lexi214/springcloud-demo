package com.gabay.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer // 开启 Config 服务端
@SpringBootApplication
public class ConfigServerApplication {

    public static void main (String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
