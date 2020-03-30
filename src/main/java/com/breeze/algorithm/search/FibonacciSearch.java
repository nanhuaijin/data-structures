package com.breeze.algorithm.search;

import java.util.Arrays;

/**
 * @author breeze
 * @date 2020/3/30
 *
 *  斐波那契查找算法：
 *
 */
public class FibonacciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 80));
    }

    //因为后面我们mid = low + F(k-1) - 1，需要使用斐波那契数列
    //因此我们需要先获得一个斐波那契数列 - 非递归方式
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     *  编写斐波那契查找算法 - 使用非非递归的方式
     * @param arr 数组
     * @param key 我们需要查找的关键值
     * @return
     */
    public static int fibSearch(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0; //存放mid值
        //获取斐波那契数列
        int[] f = fib();
        //获取斐波那契分割数值的下标
        while (right > f[k] - 1) {
            k++;
        }
        //因为fib[k] 值可能大于arr的长度，因此我们需要使用Arrays类
        //构造一个新的数组，并指向arr[] 不足的部分使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用arr数组最后的数填充temp
        //temp ={1, 8, 10, 89, 1000, 1234, 0, 0, 0}  => {1, 8, 10, 89, 1000, 1234, 1234, 1234, 1234}
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        //使用while循环处理，找到我们的数 key
        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (key < temp[mid]) {
                //向数组左边查找
                right = mid - 1;
                //为什么是k--
                //1.全部元素 = 前面的元素 + 后面的元素
                //2.f[k] = f[k-1] + f[k-2]
                //因为前面有fib[k-1]个元素，所有可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即在f[k-1] 的前面继续查找 k--
                //即下次循环 mid= f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                //想右边查找
                left = mid + 1;
                //1.全部元素 = 前面的元素 + 后面的元素
                //2.f[k] = f[k-1] + f[k-2]
                //3.因为后面我们有 f[k-2] 所有可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4.即在f[k-2]的前面几星 k-=2
                //5.即下次循环 mid = f[k-1-2]-1
                k -= 2;
            } else {
                //找到
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }
}
