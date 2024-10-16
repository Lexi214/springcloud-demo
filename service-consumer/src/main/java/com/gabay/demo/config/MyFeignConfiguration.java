package com.gabay.demo.config;

import com.gabay.demo.interceptor.MyFeignInterceptor;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfiguration {

    @Bean
    public IRule ribbonRule() { // 配置ribbon采用的负载均衡策略
        return new RandomRule();
    }

    @Bean
    public RequestInterceptor feignInterceptor() {
        return new MyFeignInterceptor();
    }
}
