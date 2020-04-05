package com.algorithm.example.generate;

import com.algorithm.example.aop.Time;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用于生成测试数据
 */
@Component
public class Generate {
    public static int MIN_VALUE = 4;

    public static int SMALL_VALUE = 100000;

    public static int MEDIUM_VALUE = 1000000;

    public static int BIG_VALUE = 10000000;

    public List<Integer> generateInt(int type) {
        int max = 0;
        if (type == 0) {
            max = MIN_VALUE;
        } else if (type == 1) {
            max = SMALL_VALUE;
        } else if (type == 2) {
            max = MEDIUM_VALUE;
        } else if (type == 3){
            max = BIG_VALUE;
        }
        List<Integer> list = new ArrayList<>(max);

        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        // 令数组的数字随机
        Collections.shuffle(list);

        return list;
    }

    public List<Integer> generateIntInRange(int type, int range) {
        int max = 0;
        if (type == 0) {
            max = MIN_VALUE;
        } else if (type == 1) {
            max = SMALL_VALUE;
        } else if (type == 2) {
            max = MEDIUM_VALUE;
        } else if (type == 3){
            max = BIG_VALUE;
        }
        List<Integer> list = new ArrayList<>(max);

        for (int i = 0; i < max; i++) {
            list.add(i%range);
        }
        // 令数组的数字随机
        Collections.shuffle(list);

        return list;
    }
}
