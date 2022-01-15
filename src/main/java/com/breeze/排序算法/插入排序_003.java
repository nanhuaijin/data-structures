package com.breeze.排序算法;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : breeze
 * @date : 2022/1/13
 * @desc :
 */
public class 插入排序_003 {
    public static void main(String[] args) {

        int[] arr = LogarithmUtils.getArray(10000, 500000);
        int[] compArr = LogarithmUtils.copyArr(arr);

        long begin = System.currentTimeMillis();
        sort(arr);
        Arrays.sort(compArr);
        long end = System.currentTimeMillis();
        boolean flag = LogarithmUtils.compareArr(arr, compArr);

        System.out.println(flag ? "success" : "fail");
        System.out.println("开始" + begin);
        System.out.println("结束" + end);
        System.out.println("差值" + (end - begin));
        // System.out.println("数组" + Arrays.toString(arr));
        // System.out.println("数组" + Arrays.toString(compArr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0-i位置有序
        for (int i = 1; i < arr.length; i++) {
            //想0-i位置有序，其实0-(j+1)位置数有序，其实j和j+1比较交换
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
