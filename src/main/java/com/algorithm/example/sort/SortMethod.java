package com.algorithm.example.sort;

import com.algorithm.example.aop.Time;
import com.algorithm.example.utils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 将数组从小到大排序
 */
@Component
public class SortMethod {

    @Time
    public void jdkSort(List<Integer> list) {
        list.sort(Integer::compareTo);
    }

    /**
     * 冒泡算法,时间复杂度 平均n的二次方。
     * @param list
     */
    @Time
    public void bubbleSort(List<Integer> list) {
        int length = list.size();
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    utils.swap(list, j, j+1);
                }
            }
        }
    }
}
