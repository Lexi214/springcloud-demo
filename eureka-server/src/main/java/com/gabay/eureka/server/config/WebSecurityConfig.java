package com.gabay.eureka.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 该配置类用于解决eureka服务端开启安全认证后，客户端CSRF的问题
 */
@EnableWebSecurity
//public class WebSecurityConfig {
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // 忽略【/eureka/**】请求
        http.csrf().ignoringAntMatchers("/eureka/**");
//        // 关闭 csrf 机制
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
    }
}
