package com.breeze.algorithm.search;

/**
 * @author breeze
 * @date 2020/3/24
 *
 *  顺序(线性)查找
 */
public class SeqSearch {
    public static void main(String[] args) {

        int[] arr = {1, 9, 11, -1, 34, 89};

        int i = seqSearch(arr, 11);
        if (i == -1) {
            System.out.println("没有找到 - " + 11);
        } else {
            System.out.println("找打了，下标是：" + i);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值就返回
     * @param arr
     * @param value
     * @return
     */
    private static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return  -1;
    }
}
