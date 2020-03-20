package com.breeze.sort;

import java.util.Arrays;

/**
 * @author breeze
 * @date 2020/3/19
 *
 *  冒泡排序  - 时间复杂度 O(n^2)
 *      1.通过对待排序序列从前向后(从下标小的元素开始)，一次比较相邻元素的值
 *  若发现逆序则交换
 *      2.因为排序的过程中，各个元素不断接近自己的位置。如果一趟比较下来没有
 *  进行过交换，就说明序列有序，因此要在排序过程中设置一个标志flag判断元素是
 *  否进行过交换。从而减少不必要的比较(这里说的标志，可以在冒泡排序写好后，在进行)
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};

        //为了容易理解，我们把冒泡排序的演变过程展示出来

        //第一趟排序，就是将最大的数排到最后
        int temp = 0;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {
            //如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第一次排序的数组：" + Arrays.toString(arr));

        //第二趟排序
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            //如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二次排序的数组：" + Arrays.toString(arr));

        //第三趟排序
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            //如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第三次排序的数组：" + Arrays.toString(arr));

        //第四趟排序，总共5个数据，只需要确定4个数据就可以
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            //如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第四次排序的数组：" + Arrays.toString(arr));
        System.out.println("=========================");

        //优化模式
        BubbleSort.sort();



    }

    private static void sort() {
        int[] arr = {3, 9, -1, 10, 20};
        //临时变量
        int temp = 0;

        for (int i = 1; i < arr.length; i++) {
            //优化算法的变量 - 是否进行过交换
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print("优化后：第" + i + "次排序的数组：");
            System.out.println(Arrays.toString(arr));

            //如果一次交换都没有发生
            if (flag) {
                break;
            }
        }
    }
}
