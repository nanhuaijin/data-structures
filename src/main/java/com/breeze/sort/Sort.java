package com.breeze.sort;

/**
 * @author breeze
 * @date 2020/3/9
 *
 * 排序：排序算法，它是将一组数据，依指定的顺序进行排列的过程
 *
 * 排序的分类：
 *      1.内部排序：指将需要处理的所有数据都加载到内部存储器中进行排序
 *          1)插入排序
 *              直接插入排序  平均O(n^2)  最坏O(n^2)
 *              希尔排序  O(nlog n)  O(n^s) 1<=s<=2
 *          2)选择排序
 *              简单选择排序 O(n^2)  O(n^2)
 *              堆排序 O(nlog n)  O(nlog n)
 *          3)交换排序
 *              冒泡排序  O(n^2)  O(n^2)
 *              快速排序  O(nlog n) O(n^2)
 *          4)归并排序   O(nlog n)  O(nlog n)
 *          5)基数排序  O(logR B)  O(logR B)
 *
 *      2.外部排序：数据量过大，无法全面加载到内存中，需要借助外部存储进行排序
 *
 * 度量一个程序的执行时间
 *      1.事后统计的方法：运行前后时间只差
 *          问题：1)要想对设计的算法的运行性能进行评测，需要实际运行该程序
 *               2)所得时间的统计量依赖于计算机的软件、硬件等环境因素
 *          这种方式，要在同一台计算机的相同状态下运行，才能比较那个算法速度更快
 *      2.事前估算的方法：通过分析某个算法的时间复杂度来判断那个算法更优
 *
 * 时间频度
 *      1.基本介绍：一个算法花费的时间和算法中语句的执行次数成正比。
 *                  哪个算法中语句执行次数多，它花费时间就多。
 *                  一个算法中语句执行次数称为语句频度或者时间频度，记作T(n)
 *      2.栗子：计算 1+2+...100
 *          方式一：for(int i = 1; i <= 100; i++) result += i
 *                  T(n) = n + 1 因为最后还需要判断一次才能退出循环
 *          方式二：result = (1+end) * end/2
 *                  T(n) = 1
 *      3.计算时间频度的时候，依照情况后面的常数项可以省略，低次幂项也可以忽略，系数可以忽略
 *
 * 时间复杂度
 *      1.一般情况下，算法中的基本操作语句的重复执行次数是问题规模n的某个函数
 *          用T(n)表示，若有某个辅助函数f(n)，使得当n趋近于无穷大时候，T(n)/f(n)
 *          的极限值为不等于零的常数，则称f(n)是T(n)的同数量级函数。记作T(n)=O(f(n))
 *          为算法的渐进时间复杂度，简称时间复杂度
 *          如：T(n)=n+1 f(n)=n ---> T(n)/f(n) = 1 ---> T(n) = O(f(n) = O(n)
 *      2.T(n)不同，但是时间复杂度可能相同。
 *          如：T(n)=n^2+7n+6 与 T(n)=3n^2+2n+2 它们的f(n)不同，但是时间复杂度不同，都是O(n^2)
 *      3.计算时间复杂度方法：
 *          用常数1代替运行时间中的所有加法常数 T(n)=3n^2+7n+6 => T(n)=3n^2+7n+1
 *          修改后的运行次数函数中，只保留最高阶项 T(n)=3n^2+7n+1 => T(n)=3n^2
 *          去除最高阶项的系数 T(n)=3n^2 => T(n)=n^2 => O(n^2)
 *
 * 常见的时间复杂度(从小到大)
 *      1.常数阶O(1)
 *      2.对数阶O(log2 n)
 *      3.线性阶O(n)
 *      4.线性对数阶O(nlog2 n)
 *      5.平方阶O(n^2)
 *      6.立方阶O(n^3)
 *      7.k次方阶O(n^k)
 *      8.指数阶O(2^n)
 *      9.阶乘 n!
 *
 * 平均时间复杂度 和 最坏时间复杂度
 *
 * 空间复杂度  => 在做算法分析的时候，主要讨论的是时间复杂度，从用户体验上更好，一般都是空间换时间
 *
 */
public class Sort {
}
