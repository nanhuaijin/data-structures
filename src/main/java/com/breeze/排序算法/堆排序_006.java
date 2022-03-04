package com.breeze.排序算法;

import java.util.Arrays;

/**
 * @author : breeze
 * @date : 2022/3/4
 * @desc :
 *
 *  数组 [6, 4,5,2]
 *  index：0，1，2，3
 *  大根堆：     6
 *             /\
 *            4  5
 *           /
 *          2
 *  左节点index：2 * index + 1
 *  右节点index：2 * index + 2
 *  父节点index: (index - 1) / 2
 */
public class 堆排序_006 {
    public static void main(String[] args) {

        int[] arr = LogarithmUtils.getArray(100000, 500000);
        int[] compArr = LogarithmUtils.copyArr(arr);
        System.out.println(Arrays.toString(arr));

        long begin = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();

        Arrays.sort(compArr);
        boolean flag = LogarithmUtils.compareArr(arr, compArr);

        System.out.println(flag ? "success" : "fail");
        System.out.println("开始" + begin);
        System.out.println("结束" + end);
        System.out.println("长度：" + arr.length + " 差值" + (end - begin));
        // System.out.println("数组" + Arrays.toString(arr));
        // System.out.println("数组" + Arrays.toString(compArr));
    }

    /**
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //变成大根堆 O(N)
        for (int i = 1; i < arr.length; i++) {
            //O(logN)
            heapInsert(arr, i);
        }

        //这种方式变成大根堆会会快一点点，但是时间复杂度没变化
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     heapify(arr, i, arr.length);
        // }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //O(N)
        while (heapSize > 0) {
            //O(logN)
            heapify(arr, 0, heapSize);
            //O(1)
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 变成大根堆的过程
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        //将二叉树顺序存在数组中，父节点 = (index - 1) /2
        while (arr[index] > arr[(index - 1) / 2]) {

            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化，即从大根堆中随意排除一个节点，再次变成大根堆的过程
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        //左节点下标
        int left = index * 2 + 1;
        //下方还有子节点的时候
        while (left < heapSize) {
            //判断是否存在右节点，右节点是否比左节点大
            int largest = left + 1 < heapSize & arr[left + 1] > arr[left]
                    ? left + 1 : left;
            //判断最大节点当前节点大小
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     *
     * @param arr
     * @param index
     * @param pIndex 父节点的index
     */
    public static void swap(int[] arr, int index, int pIndex) {
        int temp = arr[index];
        arr[index] = arr[pIndex];
        arr[pIndex] = temp;
    }
}
