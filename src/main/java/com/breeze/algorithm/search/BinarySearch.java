package com.breeze.algorithm.search;

/**
 * @author breeze
 * @date 2020/3/24
 *
 *  二分查找：
 *      1.必须是有序数组，不是有序的你需要将其转成有序
 *      2.基本思路：① 首先确定该数组的中间的下标
 *                      mid[left + right] / 2
 *                 ② 然后让需要查找的数value和arr[mid]比较，
 *                      如果大于，需要递归向右查找
 *                 ③ 和arr[mid]的值相同就返回
 *                 ④ 找到结束递归
 *                 ⑤ 递归完整个数组，也就是left > right就需要退出
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 77, 123, 432, 523, 1233};

        int i = binarySearch(arr, 43, 0, arr.length - 1);
        System.out.println(i);
    }

    /**
     * 二分查找算法
     * @param arr 数组
     * @param value 要查找的值
     * @param left 左边的索引
     * @param right 右边的索引
     * @return 找到 下标索引  没找到 -1
     */
    private static int binarySearch(int[] arr, int value, int left, int right) {

        //当left > right 时， 说明递归完毕
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (value > midVal) {//向右递归
            return binarySearch(arr, value, mid + 1, right);
        } else if (value < midVal) {
            return binarySearch(arr, value, left, mid - 1);
        } else {
            return mid;
        }

    }
}
