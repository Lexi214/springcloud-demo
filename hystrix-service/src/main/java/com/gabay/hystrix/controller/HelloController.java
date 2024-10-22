package com.gabay.hystrix.controller;

import com.gabay.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }

    @GetMapping("/hai")
    public String hai(String name) {
        return helloService.sayHai(name);
    }

}
