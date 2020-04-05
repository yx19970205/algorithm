package com.algorithm.example.sort;

import com.algorithm.example.aop.Time;
import com.algorithm.example.ListUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
     * 稳定
     * @param list
     */
    @Time
    public void bubbleSort(List<Integer> list) {
        int length = list.size();
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    ListUtils.swap(list, j, j+1);
                }
            }
        }
    }

    /**
     * 选择排序,时间复杂度 平均n的平方.
     * 以从小到大为例。
     * 不稳定
     */
    @Time
    public void selectionSort(List<Integer> list) {
        int length = list.size();
        int index;
        int max;
        for (int i = length - 1; i > 0; i--) {
            index = 0;
            max = 0;
            for (int j = 0; j <= i; j++) {
                if (list.get(j) > max) {
                    index = j;
                    max = list.get(j);
                }
            }
            ListUtils.swap(list, index, i);
        }
    }

    /**
     * 插入排序
     */
    @Time
    public void insertionSort(List<Integer> list) {
        int length = list.size();
        List<Integer> orderList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = ListUtils.binarySearch(orderList, list.get(i));
            orderList.add(index, list.get(i));
        }
    }

    /**
     * 归并排序 递归版。
     * 本来方法签名只需要 list就可以了，但是为了数组的重复使用，在原有基础上排序，所以需要给定上下界
     */
    @Time
    public void MergeSortRecursion(List<Integer> list, int begin, int end) {
        if (begin == end) {
            return ;
        }
        int middle = (begin + end) >> 1;
        MergeSortRecursion(list, begin, middle);
        MergeSortRecursion(list, middle + 1, end);
        Merge(list, begin, middle, end);
    }

    /**
     * 归并排序 非递归版本。 使用自底向上。 首先2个2个排序，再4个4个排序，以此类推到n。 和递归的方向相反。
     * @param list
     */
    @Time
    public void MergeSortIteration(List<Integer> list) {
        int size = list.size();
        for (int step = 1; step < size ; step *= 2) {
            int start = 0;
            int end;
            int middle;
            while (start < size) {
                middle = (start + step) - 1;
                end = getEnd(middle, step, size);
                Merge(list, start, middle, end);
                start = end +1;
            }
        }
    }

    private int getEnd(int middle, int step,int size) {
        int end = middle + step;
        if (end >= size) {
            return size - 1;
        }
        return end;
    }

    /**
     * [begin, middle] 一个数组 [middle+1, end] 一个数组。 合并
     * @param list
     * @param begin
     * @param middle
     * @param end
     */
    private void Merge(List<Integer> list, int begin, int middle, int end) {
        int total = end - begin + 1;
        if (total == 1) {
            return ;
        }
        List<Integer> newList = new ArrayList<>(total);
        int start1 = begin;
        int start2 = middle + 1;
        while (total > 0) {
            if (start1 > middle) {
                newList.add(list.get(start2));
                start2 ++;
            } else if (start2 > end) {
                newList.add(list.get(start1));
                start1 ++;
            }
            // 看谁小, 谁小就附加到新数组。
            else if (list.get(start1) < list.get(start2)) {
                newList.add(list.get(start1));
                start1 ++;
            } else {
                newList.add(list.get(start2));
                start2 ++;
            }
            total --;
        }
        // list的区间是 [beigin, end] newList 是 [0, total)
        for (int i = begin; i <= end ; i++) {
            list.set(i, newList.get(i - begin));
        }
    }

    /**
     * 快速排序。
     * 1. 首先选择一个数当基准，这里叫A。 (常见选择第一个 中间 最后一个)
     * 2. 找出一个位置K，另其左边小于基准的数，右边大于基准的数。 需要的swap一些数据。
     * 3. 把A放在K上。 对其左右二边的数组继续以上1,2的步骤。
     * @param list
     */
    @Time
    public void QuickSort(List<Integer> list, int begin, int end) {
        if (begin >= end) {
            return ;
        }
        int k = Partition(list, begin, end);
        QuickSort(list, begin, k - 1);
        QuickSort(list, k + 1, end);
    }

    /**
     * 选取第一个当基准A。 从右往左找一个小于A的数，从左往右找一个大于A的数，swap。
     * 这里有个细节，如果我是选择第一个当基准，那么找可swap的元素首先要从右边找。
     * 之前也想不清为啥要这么做。但是找个反例就知道不这么做会导致什么了。
     * 6 3 11 9. 首先按先从左往右。 直接找到3. 再从右往左，在3碰面。 说明K的左边是3的下标。正常
     * 如果是按从右往左先, 找一个大于6的，是11. 但是我们从右往左找到11就碰面了，找不到小于6的。
     * @param list
     * @param begin
     * @param end
     * @return K的坐标
     */
    private int Partition(List<Integer> list, int begin, int end) {
        int kValue = list.get(begin);
        int left = begin;
        int right = end;
        while (left < right) {
            while (list.get(right) >= kValue && (right > left)) {
                right --;
            }
            while (list.get(left) <= kValue && (left < right)) {
                left ++;
            }
            ListUtils.swap(list, left, right);
        }
        ListUtils.swap(list, begin, right);
        return right;
    }

    /**
     * 计数排序， 对于某些特性的场合能达到O(n).
     *
     * @param list
     */
    @Time
    public void CountingSort(List<Integer> list) {
        int[] count = new int[100];
        for (int i = 0; i < list.size(); i++) {
            count[list.get(i)] ++;
        }
        int begin = 0;
        for (int i = 0; i < 100; i++) {
            while (count[i] > 0) {
                list.set(begin, i);
                count[i] --;
                begin++;
            }
        }
    }
}
