package com.breeze.每日一练;

/**
 * @author : breeze
 * @date : 2022/1/15
 * @desc : 递归求数组最大值
 */
public class 递归求数组最大值_002 {
    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(search(arr, 0, arr.length - 1));
    }

    public static int search(int[] arr, int l, int r) {
        //两种特殊情况
        if (l == r) {
            return arr[l];
        }

        //取中点 由于l+r有可能越界，所以采用 r-l除以2 + l的写法
        int mid = l + ((r - l) >> 1);
        int leftMax = search(arr, l, mid);
        int rightMax = search(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
