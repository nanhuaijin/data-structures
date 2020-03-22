package com.breeze.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author breeze
 * @date 2020/3/22
 *
 *  希尔排序：
 *      1.也是一种插入排序，是简单插入排序经过改进之后的一个更高效
 *  的版本，也称为缩小增量排序
 *      2.排序思想：希尔排序是把记录按下标的一定增量分组，对每组使用
 *  直接插入排序算法排序。随着增量逐渐减少，每组包含的关键词越来越多，
 *  当增量减至1时，整个文件恰被分成一组，算法终止（不太好理解，可以看脑图）
 *
 *  ① 希尔排序时，对有序序列在插入时采用交换法  10s 10s  12s
 *  ② 希尔排序时，对有序序列在插入时采用移动法
 */
public class ShellSort {
    public static void main(String[] args) {

//        shellSortByStep(arr);


        //优化模式
        int[] arr = new int[80000];
        //测试希尔排序算法时间
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //随机生成一个[0, 8000000)数
        }
        //开始时间
        Date begin = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("排序前时间：" + format.format(begin));

        shellSort2(arr); //除以2的时间：104毫秒  160毫秒 94毫秒
                        //除以3的时间：136ms  114ms  102ms

        //结束时间
        Date end = new Date();
        System.out.println("排序前时间：" + format.format(end));

    }

    /**
     * 移位法
     * @param arr
     */
    private static void shellSort2(int[] arr) {

        int j = 0;
        int temp = 0;

        //增量gap 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环后就给出temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 交换法 优化版
     * @param arr
     */
    private static void shellSort(int[] arr) {

        int temp = 0;
//        int count = 0;
        //增量gap 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共5组，每组有2个元素)步长是5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("第" + (++count) + "次排序结果：" + Arrays.toString(arr));
        }

    }


    /**
     * 采用逐步推导的方式 --- 交换法
     * @param arr
     */
    private static void shellSortByStep(int[] arr) {
        int temp = 0;
        //希尔排序的第一轮
        //因为第一轮排序，是将10个数据分成了10/2 = 5组
        for (int i = (arr.length / 2); i < arr.length; i++) {
            //遍历各组中所有的元素(共5组，每组有2个元素)步长是5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明需要交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第1次排序结果：" + Arrays.toString(arr));

        //希尔排序的第2轮
        //因为第2轮排序，是将10个数据分成了10/2/2 = 2组
        for (int i = (arr.length / 2 / 2); i < arr.length; i++) {
            //遍历各组中所有的元素(共5组，每组有2个元素)步长是5
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明需要交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第2次排序结果：" + Arrays.toString(arr));

        //希尔排序的第3轮
        //因为第3轮排序，是将10个数据分成了10/2/2/2 = 1组
        for (int i = (arr.length / 2 / 2 / 2); i < arr.length; i++) {
            //遍历各组中所有的元素(共5组，每组有2个元素)步长是5
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明需要交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第3次排序结果：" + Arrays.toString(arr));

    }
}
