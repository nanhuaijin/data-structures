package com.breeze.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author breeze
 * @date 2020/3/22
 *
 *  快速排序：
 *      1.是对冒泡排序的一种改进。
 *      2.基本思想：通过一趟排序将要排序的数据分割成独立的两部分
 *  其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按
 *  此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行
 *  以此达到整个数据变成有序序列
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        //测试快速排序算法时间
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //随机生成一个[0, 8000000)数
        }
        //开始时间
        Date begin = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("排序前时间：" + format.format(begin));
        //127ms  64ms  120ms  在数据量越来越大的情况下 快排空间换时间会比希尔快
        quickSort(arr, 0, arr.length - 1);

        //结束时间
        Date end = new Date();
        System.out.println("排序前时间：" + format.format(end));


    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right; //右下标
        int pivot = arr[(left + right) / 2]; //中轴值
        int temp = 0; //临时变量

        //while循环的目的是让比pivot值小的放到左边，大的放右边
        while (l < r) {
            //在左边一直找，找到一个比pivot小的
            while (arr[l] < pivot) {
                l += 1;
            }
            //往右边一直找，找到一个比pivot大的
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果左索引大于等于右索引，所以左边已经全是小于等于pivot
            //右边已经全是大于等于pivot的值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后，发现这个arr[l] == pivot值，相等 让r--
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换后，发现这个arr[r] == pivot值，相等 让l++
            if (arr[r] == pivot) {
                l += 1;
            }
        }
//        System.out.println(Arrays.toString(arr));
        //如果 l==r ,必须l++ r-- 否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
