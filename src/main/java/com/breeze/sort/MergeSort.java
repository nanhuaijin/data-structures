package com.breeze.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author breeze
 * @date 2020/3/22
 *
 *  归并排序
 *      1.是利用归并的思想实现的排序方法，该算法采用经典的分治(divide-and-conquer)
 *  策略(分治法将问题分成一些小的问题然后递归求解，而治的阶段则是将分
 *  的阶段得到的各个答案“修补”在一起，即分而治之)
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        int[] temp = new int[arr.length]; //归并排序需要一个额外的空间
        //测试归并排序算法时间
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //随机生成一个[0, 8000000)数
        }
        //开始时间
        Date begin = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("排序前时间：" + format.format(begin));
        //157ms  176ms  121ms
        mergeSort(arr, 0, arr.length - 1, temp);

        //结束时间
        Date end = new Date();
        System.out.println("排序前时间：" + format.format(end));

//        System.out.println("归并排序后：" + Arrays.toString(arr));
    }

    /**
     * 分 + 合 的方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid+1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并的方法
     * @param arr  合并的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始索引
        int t= 0; //指向中转数组temp的当前索引(待插入数据的位置索引)

        //1.先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕
        while (i <= mid && j <= right) {
            //如果左边有序序列的当前元素小于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组中
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {//反之将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2.把有剩余数据的一边的数据一次全部填充到temp
        while (i <= mid) {//说明左边有序序列还有剩余的元素，全部拷贝到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.将我们的temp数组重新拷贝到arr
        //注意，并不是每次都拷贝所有的
        t = 0;
        int tempLeft = left;
        //第一次合并tempLeft = 0，right = 1 // tempLeft= 2 right = 3 //tL = 0，ri = 3
        //最后一次tempLeft= 0 right = 7
//        System.out.println("tempLeft: " + tempLeft + ", right: " + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft ++;
        }
    }
}
