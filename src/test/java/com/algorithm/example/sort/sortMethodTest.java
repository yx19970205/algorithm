package com.algorithm.example.sort;

import com.algorithm.example.aop.Time;
import com.algorithm.example.generate.Generate;
import com.algorithm.example.utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Integer> list = generate.generateInt(0);
        sortMethod.jdkSort(list);

        System.out.println("是否正常排序:" + utils.isSort(list));
        System.out.println("----------------------------");
    }

    @Test
    public void bubbleSortTest() {
        System.out.println("冒泡排序");
        List<Integer> list = generate.generateInt(0);
        sortMethod.bubbleSort(list);
        System.out.println("是否正常排序:" + utils.isSort(list));
        System.out.println("----------------------------");
    }

}