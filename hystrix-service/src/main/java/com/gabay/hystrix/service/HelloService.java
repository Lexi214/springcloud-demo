package com.gabay.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @HystrixCommand(fallbackMethod = "sayHelloFallback") // 服务降级
    public String sayHello(String name) {
        // 模拟异常情况
        if (name.equals("Monster")) {
            throw new RuntimeException();
        }
        return "Hello! " + name + ".";
    }

    @HystrixCommand(commandProperties = {
            // 启用断路器
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),
            // 设置熔断器在一个滚动窗口中关闭到打开状态所需的最小请求数，默认是20，此处设置为5个
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "5"),
            // 设置请求线程失败比率，当失败百分比达到或超过这个值时，熔断器将打开，默认是50
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
            // 设置熔断器在打开状态后的休眠时间，熔断机制重试策略的时间间隔，默认是5秒重试一次
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5"),
    }, fallbackMethod = "sayHelloFallback") // 服务熔断
    public String sayHai(String name) {
        // 模拟异常情况
        if (name.equals("Monster")) {
            throw new RuntimeException();
        }
        return "Hai! " + name + ".";
    }

    public String sayHelloFallback(String name) {
        System.out.println("wrong...");
        return "I'm sorry. There is something wrong.";
    }

}
