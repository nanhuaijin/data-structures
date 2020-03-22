package com.breeze.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author breeze
 * @date 2020/3/22
 *
 *  插入排序：
 *      1.插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻
 *  元素的适当位置，以达到排序的目的
 *      2.排序思想：把n个待排序的元素看成一个有序表和一个无序表，开始
 *  时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次
 *  从无序表中取出第一个元素，把它的排序码一次与有序表元素的排序码进行
 *  比较，将它插入到有序表中适当位置，使之成为新的有序表
 */
public class InsertSort {
    public static void main(String[] args) {

        //优化模式
        int[] arr = new int[80000];
        //测试插入排序算法时间
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //随机生成一个[0, 8000000)数
        }
        //开始时间
        Date begin = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前时间：" + format.format(begin));

        InsertSort.insertSort(arr); //2s 1s 1s

        //结束时间
        Date end = new Date();
        System.out.println("排序前时间：" + format.format(end));

    }

    /**
     * 优化模式
     * @param arr
     */
    private static void insertSort(int[] arr) {
        //定义在for循环外边减少开销
        int insetVal = 0;
        int insertIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            //第一轮{101, 34, 119, 1} => {34, 101, 119 ,1}
            //定义待插入的数
            insetVal = arr[i+1];
            insertIndex = i;//即arr[1]前面这个数的下标

            //给insertVal 找到插入的位置
            //1.insertIndex >= 0 保证不越界
            //2.insetVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            //3.就需要将insertIndex 后移
            while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            if (insertIndex != i) {
                arr[insertIndex + 1] = insetVal;
            }
//            System.out.println("第" + (i+1) + "轮插入后：" + Arrays.toString(arr));
        }
    }

    /**
     * 采用初步推导的方式
     * @param arr
     */
    private static void insertSortByStep(int[] arr) {

        //第一轮{101, 34, 119, 1} => {34, 101, 119 ,1}
        //定义待插入的数
        int insetVal = arr[1];
        int insertIndex = 0;//即arr[1]前面这个数的下标

        //给insertVal 找到插入的位置
        //1.insertIndex >= 0 保证不越界
        //2.insetVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3.就需要将insertIndex 后移
        while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insetVal;
        System.out.println("第1轮插入后：" + Arrays.toString(arr));

        //第二轮
        //定义待插入的数
        insetVal = arr[2];
        insertIndex = 1;//即arr[1]前面这个数的下标

        //给insertVal 找到插入的位置
        //1.insertIndex >= 0 保证不越界
        //2.insetVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3.就需要将insertIndex 后移
        while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insetVal;
        System.out.println("第2轮插入后：" + Arrays.toString(arr));

        //第三轮
        //定义待插入的数
        insetVal = arr[3];
        insertIndex = 2;//即arr[1]前面这个数的下标

        //给insertVal 找到插入的位置
        //1.insertIndex >= 0 保证不越界
        //2.insetVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3.就需要将insertIndex 后移
        while (insertIndex >= 0 && insetVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insetVal;
        System.out.println("第3轮插入后：" + Arrays.toString(arr));

    }
}
