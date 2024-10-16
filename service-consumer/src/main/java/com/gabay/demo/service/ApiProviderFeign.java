package com.gabay.demo.service;

import com.gabay.demo.config.MyFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 采用 OpenFeign 调用 gabay-service-provider 微服务
 */
//@FeignClient(name = "gabay-service-provider", url = "http://localhost:8092")
@FeignClient(value = "gabay-service-provider", path = "/api")
public interface ApiProviderFeign {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

}
