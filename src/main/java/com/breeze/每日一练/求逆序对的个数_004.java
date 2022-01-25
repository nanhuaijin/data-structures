package com.breeze.每日一练;

import java.util.Arrays;

/**
 * @author : breeze
 * @date : 2022/1/25
 * @desc : 逆序对问题，在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，打印所有的逆序对
 */
public class 求逆序对的个数_004 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(sort(arr, 0, arr.length - 1));
    }

    public static int sort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        return sort(arr, l, mid)
                + sort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int total = 0;
        while (p1 <= l && p2 <= r) {
            if (arr[p1] > arr[p2]) {
                total++;
                System.out.println("[" + arr[p1] + ", " + arr[p2] + "]");
            }
            // total += arr[p1] < arr[p2] ? 0 : 1;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= l) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
        return total;
    }
}
