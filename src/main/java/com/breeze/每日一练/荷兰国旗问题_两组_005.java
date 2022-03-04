package com.breeze.每日一练;

import java.util.Arrays;

/**
 * @author : breeze
 * @date : 2022/1/25
 * @desc :
 */
public class 荷兰国旗问题_两组_005 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        swap(arr, 5);
    }

    public static void swap(int[] arr, int num) {
        //小于等于区域
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                if (i != l) {
                    arr[l] = arr[l] ^ arr[i];
                    arr[i] = arr[l] ^ arr[i];
                    arr[l] = arr[l] ^ arr[i];
                }
                l++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
