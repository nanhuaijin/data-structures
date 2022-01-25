package com.breeze.每日一练;

import java.util.Arrays;

/**
 * @author : breeze
 * @date : 2022/1/21
 * @desc : 数组中，当前数的左边比它小的数之和，称为当前数的小和，
 *          数组的小和，是所有数的小和之和
 */
public class 求数组小和_003 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(sort(arr, 0, arr.length - 1));
    }

    public static int sort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return sort(arr, l, mid)
                + sort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        System.out.println(Arrays.toString(arr));
        return res;
    }
}
