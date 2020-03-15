package com.algorithm.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class utils {
    public static void swap(List<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    public static boolean arrEquals(List<Integer> list, List<Integer> orderList) {
        int length = list.size();
        int length2= orderList.size();
        if (length != length2) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!list.get(i).equals(orderList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断改数组是否已经排序，目前只考虑从小到大
     * @param list
     * @return
     */
    public static boolean isSort(List<Integer> list) {
        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
