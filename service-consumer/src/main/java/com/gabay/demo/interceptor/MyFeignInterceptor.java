package com.gabay.demo.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("feignTargetName -> " + requestTemplate.feignTarget().name());
        System.out.println("feignTargetUrl -> " + requestTemplate.feignTarget().url() + requestTemplate.url());
    }
}
