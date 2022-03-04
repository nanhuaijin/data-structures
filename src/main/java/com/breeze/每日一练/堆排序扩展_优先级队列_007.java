package com.breeze.每日一练;

import java.util.PriorityQueue;

/**
 * @author : breeze
 * @date : 2022/3/4
 * @desc : 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择合适的排序
 * 算法针对这个数据进行排序。
 *
 * 假设k=6，取前7个数组成一个小根堆，那么这个小根堆中最小的数，就在0位置上
 * 然后弹出小根堆的最小值，把第八个数加入这个小根堆，最小数在1位置，周而复始，就可以得到有序数组。
 *
 */
public class 堆排序扩展_优先级队列_007 {
    public static void main(String[] args) {
        //优先级队列，就是堆结构 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);
        heap.add(3);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认是最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
