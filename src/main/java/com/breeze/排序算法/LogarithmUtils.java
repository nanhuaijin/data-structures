package com.breeze.排序算法;

/**
 * @author : breeze
 * @date : 2022/1/15
 * @desc : 对数器工具类
 */
public class LogarithmUtils {

    /**
     * 生成随机数组
     * @param maxSize 数组最大大小
     * @param maxValue 数组中数最大值
     * @return
     */
    public static int[] getArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((Math.random() * maxSize) + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue - Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 深拷贝数组
     * @param arr
     * @return
     */
    public static int[] copyArr(int[] arr) {
        int[] compArr = new int[arr.length];
        for (int i = 0; i < compArr.length; i++) {
            int temp = arr[i];
            compArr[i] = temp;
        }
        return compArr;
    }

    /**
     * 比较两个数组是否全等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean compareArr(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
