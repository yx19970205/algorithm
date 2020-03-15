package com.algorithm.example.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectJConfig {
    @Bean
    public TimeAspect timeAspect() {
        return new TimeAspect();
    }
}
