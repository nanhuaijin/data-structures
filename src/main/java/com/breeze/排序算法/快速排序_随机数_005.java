package com.breeze.排序算法;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : breeze
 * @date : 2022/1/25
 * @desc : 快排
 */
public class 快速排序_随机数_005 {
    public static void main(String[] args) {

        int[] arr = LogarithmUtils.getArray(100000, 500000);
        // int[] arr = {4, 3, 6, 7, 2, 8, 1, 4};
        int[] compArr = LogarithmUtils.copyArr(arr);
        // System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        // sort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        Arrays.sort(compArr);
        boolean flag = LogarithmUtils.compareArr(arr, compArr);

        System.out.println(flag ? "success" : "fail");
        System.out.println("开始" + begin);
        System.out.println("结束" + end);
        System.out.println(arr.length + " 差值" + (end - begin));
        // System.out.println("数组" + Arrays.toString(arr));
        // System.out.println("数组" + Arrays.toString(compArr));
    }

    /**
     * 取最左侧的数为基准数进行判断，但是会出现[5,4,3,2,1]这种情况，时间复杂度就会变成O(N^2)
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //小于区域 右边界
        int l = left;
        //大于区域 左边界
        int r = right;
        int num = arr[left];

        while (l < r) {

            while (arr[r] >= num && l < r) {
                r--;
            }
            while (arr[l] <= num && l < r) {
                l++;
            }

            //左边界小于右边界，交换
            if (l < r) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }

        arr[left] = arr[l];
        arr[l] = num;
        // System.out.println(Arrays.toString(arr));
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);

    }

    /**
     * 取随机数作为基准数比较，时间复杂度可以平均到O(N*logN)
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //小于区域 右边界
        int l = left;
        //大于区域 左边界
        int r = right;
        //随机选取一个数，为了避免发生类似二叉树左倾右倾的问题，避免最差情况O(N^2)
        int random = new Random().nextInt(right - left + 1) + left;
        // System.out.print(left + " - ");
        // System.out.print(right + " - ");
        // System.out.print(random);
        int num = arr[random];

        while (l < r) {

            while (arr[r] > num) {
                r--;
            }
            while (arr[l] < num) {
                l++;
            }

            if (l >= r) {
                break;
            }

            //左边界小于右边界，交换
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            if (arr[l] == num) {
                r--;
            }
            if (arr[r] == num) {
                l++;
            }

        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
