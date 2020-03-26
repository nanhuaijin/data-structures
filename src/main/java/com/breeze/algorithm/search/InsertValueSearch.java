package com.breeze.algorithm.search;

/**
 * @author breeze
 * @date 2020/3/26
 *
 *  插值查找算法：
 *      1.类似于二分查找，不同的是查值查找每次从自适应mid处开始查找
 *      2.将折半查找中的求mid索引的公式，low表示左边索引left，
 *  right表示右边索引right  key就是findVal
 *      int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left])
 */
public class InsertValueSearch {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int i = insertValueSearch(arr, 0, 99, 100);
        System.out.println("index：" + i);

    }

    /**
     *  插值查找算法要求数组是有序的
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param find 要查找的值
     * @return
     */
    private static int insertValueSearch(int[] arr, int left, int right, int find) {
        int count = 1;
        System.out.println(count++);
        //这个必须有，否则可能越界
        if (left > right || find < arr[0] || find > arr[arr.length - 1]) {
            return -1;
        }

        //自适应中间索引mid
        int mid = left + (right - left) * (find - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (find > midVal) {
            return insertValueSearch(arr, mid + 1, right, find);
        } else if (find < midVal) {
            return insertValueSearch(arr, left, mid - 1, find);
        } else {
            return mid;
        }
    }
}
