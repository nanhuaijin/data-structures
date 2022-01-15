package com.breeze.排序算法;

import java.util.Random;

/**
 * @author : breeze
 * @date : 2022/1/13
 * @desc : 选择排序算法 - 选择最小值放到前面位置
 *
 */
public class 选择排序_001 {
    public static void main(String[] args) {

        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(10000000);
        }
        long begin = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(begin);
        System.out.println(end);
        System.out.println(end - begin);
        // System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {

                minIndex = arr[j] < arr[i] ? j : minIndex;
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
