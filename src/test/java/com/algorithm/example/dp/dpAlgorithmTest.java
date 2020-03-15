package com.algorithm.example.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class dpAlgorithmTest {

    @Autowired
    private DpAlgorithm dpAlgorithm;

    @Test
    public void doTest() {
        Instant start = Instant.now();
        int count = dpAlgorithm.doSolve(0, 35);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("一共有多少种解法: " + count);
        System.out.println("方法执行时间:" + duration.toMillis() + "毫秒");
    }

    @Test
    public void doTest2() {
        Instant start = Instant.now();
        int count = dpAlgorithm.doSolve2(35);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("一共有多少种解法: " + count);
        System.out.println("方法执行时间:" + duration.toMillis() + "毫秒");
    }

    @Test
    public void doTest3() {
        Instant start = Instant.now();
        int count = dpAlgorithm.doSolveWithCache(35);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("一共有多少种解法: " + count);
        System.out.println("方法执行时间:" + duration.toMillis() + "毫秒");
    }

    @Test
    public void doTest4() {
        int count = dpAlgorithm.doSolveWithCache(35);
        System.out.println("一共有多少种解法: " + count);
    }
}