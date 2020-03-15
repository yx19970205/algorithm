package com.algorithm.example.dp;

import com.algorithm.example.aop.Time;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DpAlgorithm {

    private Map<Integer, Integer> maps = new HashMap<>();

    /**
     * 暴力解法
     *
     * @param index 代表目前在第几层阶梯
     * @param n     代表总共多少层
     * @return
     */
    public int doSolve(int index, int n) {
        if (index > n) {
            return 0;
        }
        if (index == n) {
            return 1;
        }
        return doSolve(index + 1, n) + doSolve(index + 2, n);
    }

    public int doSolve2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return doSolve2(n - 1) + doSolve2(n - 2);
    }

    public int doSolveWithCache(int n) {
        if (maps.get(n) != null) {
            return maps.get(n);
        }
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int v1 = doSolveWithCache(n - 1);
        int v2 = doSolveWithCache(n - 2);
        maps.put(n - 1, v1);
        maps.put(n - 2, v2);
        return v1 + v2;
    }

    /**
     * 动态规划
     * 只考虑 n >= 3的情况
     * @param n 代表总共多少层
     * @return
     */
    @Time
    public int doSolveByDp(int n) {
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }
}
