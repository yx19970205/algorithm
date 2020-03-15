package com.algorithm.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
public class TimeAspect {

    @Pointcut("@annotation(com.algorithm.example.aop.Time)")
    //@Pointcut(value = "execution(* com.algorithm.example.generate.Generate.*(..))")
    public void time() {}

    @Around("time()")
    public Object statisticsTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object object = joinPoint.proceed();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("方法执行时间:" + duration.toMillis() + "毫秒");
        return object;
    }
}
