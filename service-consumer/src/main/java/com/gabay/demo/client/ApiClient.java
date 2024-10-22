package com.gabay.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 采用 OpenFeign 调用 gabay-service-provider 微服务
 */
//@FeignClient(name = "gabay-service-provider", url = "http://localhost:7001")
@FeignClient(value = "gabay-service-provider", path = "/api")
public interface ApiClient {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

}
