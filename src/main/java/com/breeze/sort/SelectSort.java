package com.breeze.sort;

import java.util.Arrays;

/**
 * @author breeze
 * @date 2020/3/20
 *
 *  选择排序  - 时间复杂度 O(n^2)
 *      1.选择式排序也属于内部排序法，是从欲排序的数据中，按照指定
 *  的规则选出某一元素，再依规定交换位置达到排序的目的。
 *      2.思想：第一次从arr[0] ~ arr[n-1] 中选取最小的值和arr[0]
 *  交换，第二次从arr[1] ~ arr[n-1] 中选取最小的值和arr[1]交换
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = {101, 340, 119, 1};
        int[] arr1 = {101, 340, 119, 1};

        selectSortBySept(arr);
        System.out.println("===========");
        selectSort(arr1);
    }

    /**
     * 优化版本
     * @param arr
     */
    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[minIndex];

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第" + (i+1) + "次排序结果：" + Arrays.toString(arr));
        }
        
    }
    
    /**
     * 这个方法采用逐步推到的方式，讲解选择排序
     * @param arr
     */
    private static void selectSortBySept(int[] arr) {

        //第一轮
        int minIndex = 0;
        int min = arr[minIndex];

        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        //将最小值，放到arr[0]位置，即交换
        arr[minIndex] = arr[0];
        arr[0] = min;
        System.out.println("第一次排序后结果：" + Arrays.toString(arr));

        //第二轮
        minIndex = 1;
        min = arr[minIndex];

        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        //将最小值，放到arr[0]位置，即交换
        arr[minIndex] = arr[1];
        arr[1] = min;
        System.out.println("第二次排序后结果：" + Arrays.toString(arr));

        //第三轮
        minIndex = 2;
        min = arr[minIndex];

        for (int i = 2 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        //将最小值，放到arr[0]位置，即交换
        arr[minIndex] = arr[2];
        arr[2] = min;
        System.out.println("第三次排序后结果：" + Arrays.toString(arr));
    }
}
