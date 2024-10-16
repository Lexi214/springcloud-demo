package com.gabay.demo.controller;

import com.gabay.demo.client.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        String text = apiClient.hello(name);
        return text + " I'm Demo.";
    }

}
