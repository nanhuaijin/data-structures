package com.breeze.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author breeze
 * @date 2020/3/24
 *
 *  基数排序：  空间换时间
 *      1.属于“分布式排序”（distribution sort），又称“桶子法”
 *  它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到
 *  排序的目的
 *      2.技术排序法是属于稳定性的排序，技术排序法是效率高的稳定法
 *      3.技术排序是桶排序的扩展
 *      4.技术排序是1887年赫尔曼-何乐礼发明的，它是这样实现的：将
 *  整数按位数割成不同的数字，然后按每个位数分别比较
 *      5.基本思想：① 将所有待比较数值统一为同样的数位长度，数位较
 *  短的数前面补零。然后，从最低位开始，一次进行一次排序。这样从最低
 *  位排序一直到最高位排序完成以后，数列就变成有序序列
 */
public class RadixSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        //测试基数排序算法时间
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //随机生成一个[0, 8000000)数
        }
        //开始时间
        Date begin = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("排序前时间：" + format.format(begin));
        //126ms  133ms  152ms
        radixSort(arr);

        //结束时间
        Date end = new Date();
        System.out.println("排序前时间：" + format.format(end));

    }

    /**
     * 基数排序整合版
     * @param arr
     */
    private static void radixSort(int[] arr) {

        //得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.二维数组包含10个一维数组
        //2.为了防止堆栈溢出，每个桶的大小是arr.length()
        //3.空间换时间
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个
        // 一维数组来记录各个桶每次放入的数据个数
        //第一个位置，记录第一个桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        //使用循环的方式，将代码处理下
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {
            //第1轮：针对每个元素的个位进行排序处理
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位上的数
                int digit = arr[i] / n % 10;
                bucket[digit][bucketElementCounts[digit]] = arr[i];
                bucketElementCounts[digit]++;
            }

            //按照这个桶的顺序取出数据
            int index = 0;
            //遍历被一个桶，并将桶中的数据放入到原数组
            for (int i = 0; i < bucket.length; i++) {
                //如果桶中有数据,我们才放入到原数组
                if (bucketElementCounts[i] != 0) {
                    //循环该桶即第i个一维数组
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        //取出元素放入到arr
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                //第一轮处理后，需要将bucketElementCounts[i]置零
                bucketElementCounts[i] = 0;
            }

//            System.out.println("第" + (k + 1) + "轮基数排序的结果：" + Arrays.toString(arr));

        }

    }


    /**
     * 基数排序 - 一步一步来
     * @param arr
     */
    private static void radixSortByStep(int[] arr) {

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.二维数组包含10个一维数组
        //2.为了防止栈溢出，每个桶的大小是arr.length()
        //3.空间换时间
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个
        // 一维数组来记录各个桶每次放入的数据个数
        //第一个位置，记录第一个桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        //第1轮：针对每个元素的个位进行排序处理
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位上的数
            int digit = arr[i] % 10;
            bucket[digit][bucketElementCounts[digit]] = arr[i];
            bucketElementCounts[digit]++;
        }

        //按照这个桶的顺序取出数据
        int index = 0;
        //遍历被一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据,我们才放入到原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶即第i个一维数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //第一轮处理后，需要将bucketElementCounts[i]置零
            bucketElementCounts[i] = 0;
        }

        System.out.println("第1轮基数排序的结果：" + Arrays.toString(arr));

        //第2轮：针对每个元素的十位进行排序处理
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的十位上的数
            int digit = arr[i] / 10 % 10;
            bucket[digit][bucketElementCounts[digit]] = arr[i];
            bucketElementCounts[digit]++;
        }

        //按照这个桶的顺序取出数据
        index = 0;
        //遍历被一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据,我们才放入到原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶即第i个一维数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //第二轮处理后，需要将bucketElementCounts[i]置零
            bucketElementCounts[i] = 0;
        }

        System.out.println("第2轮基数排序的结果：" + Arrays.toString(arr));

        //第3轮：针对每个元素的百位进行排序处理
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的百位上的数
            int digit = arr[i] / 100 % 10;
            bucket[digit][bucketElementCounts[digit]] = arr[i];
            bucketElementCounts[digit]++;
        }

        //按照这个桶的顺序取出数据
        index = 0;
        //遍历被一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据,我们才放入到原数组
            if (bucketElementCounts[i] != 0) {
                //循环该桶即第i个一维数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //第二轮处理后，需要将bucketElementCounts[i]置零
            bucketElementCounts[i] = 0;
        }

        System.out.println("第2轮基数排序的结果：" + Arrays.toString(arr));
    }
}
