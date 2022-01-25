package com.breeze.排序算法;

import java.util.Arrays;

/**
 * @author : breeze
 * @date : 2022/1/13
 * @desc :
 */
public class 归并排序_004 {
    public static void main(String[] args) {

        int[] arr = LogarithmUtils.getArray(10000, 500000);
        int[] compArr = LogarithmUtils.copyArr(arr);

        long begin = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
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

    public static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }
}
