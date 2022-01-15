package com.breeze.排序算法;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : breeze
 * @date : 2022/1/13
 * @desc :
 */
public class 冒泡排序_002 {
    public static void main(String[] args) {

        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        long begin = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(begin);
        System.out.println(end);
        System.out.println(end - begin);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j + 1] ^ arr[j];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                }
            }
        }
    }
}
