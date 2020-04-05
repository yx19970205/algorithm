package com.algorithm.example.sort;

import com.algorithm.example.aop.Time;
import com.algorithm.example.generate.Generate;
import com.algorithm.example.ListUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class sortMethodTest {
    @Autowired
    private Generate generate;

    @Autowired
    private SortMethod sortMethod;

    @Test
    public void jdkSort() {
        System.out.println("Jdk-自带排序");
        List<Integer> list = generate.generateInt(1);
        sortMethod.jdkSort(list);

        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    public void bubbleSortTest() {
        System.out.println("冒泡排序");
        List<Integer> list = generate.generateInt(1);
        sortMethod.bubbleSort(list);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    public void selectionSortTest() {
        System.out.println("选择排序");
        List<Integer> list = generate.generateInt(1);
        sortMethod.selectionSort(list);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    public void insertionSortTest() {
        System.out.println("插入排序");
        List<Integer> list = generate.generateInt(1);
        sortMethod.selectionSort(list);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    @Test
    public void MergeSortRecursion() {
        System.out.println("归并排序 递归版");
        List<Integer> list = generate.generateInt(1);
        sortMethod.MergeSortRecursion(list, 0, list.size() - 1);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    @Test
    public void MergeSortIterationTest() {
        System.out.println("递归排序 非递归版");
        List<Integer> list = generate.generateInt(1);
        sortMethod.MergeSortIteration(list);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    @Test
    public void QuickSortTest() {
        System.out.println("快速排序 递归版");
        List<Integer> list = generate.generateInt(1);
        sortMethod.QuickSort(list, 0, list.size() - 1);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }

    @Test
    public void CountingSortTest() {
        System.out.println("计数排序");
        // 测试10w个数，都在100以内
        List<Integer> list = generate.generateIntInRange(1, 100);
        sortMethod.CountingSort(list);
        System.out.println("是否正常排序:" + ListUtils.isSort(list));
    }
}