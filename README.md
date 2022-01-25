# 数据结构与算法

## 一、时间复杂度

1.常数操作：一个操作如果和样本的数据量没有关系，每次都是固定时间内完成的操作。

> 比如加减乘除、比较、数组交换操作、位运算...

2.等差数列通项公式：an = a1 + (n-1)d

3.等差数列求和公式：Sn = na1 + n(n-1)d/2         Sn = n(a1+an)/2

4.**时间复杂度：**写出常数操作数量的表达式，只要最高阶项，不要低阶项，也不要最高阶项的系数，剩下的部分如果是f(N)，那么时间复杂度就是O(f(N))，并且按照最坏情况取值

> 比如 aN^2 + bN + c 取最高项 aN^2，去除系数N^2 时间复杂度O(n^2)

5.最高阶项排序：n^n  >  n^2 > nlogn > n > logn > c

6.评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是“常数项时间”。

## 二、额外空间复杂度
## 三、排序算法
1.位运算
- 与 & ：都为1才为1
- 或 | ：有一个为1就为1
- 非 ~ ：取反
- 异或 ^ ：不同为1，相同为0，也叫做无进位相加
> 0 ^ N = N  N ^ N = 0
>
> 异或符合交换结合律 
>
> 使用异或交换两个数ab的值，前提是ab指向的内存地址是不同的，如果内存地址相同，ab就会变成0
- a & (a - 1) 如果a>0一直执行，最终a=0，那么执行的次数就是a中1的个数 

> 1010 & 1001 = 1000 & 0111 = 0000 2次 即2个

- a & (~a + 1) 得到a最右边为1，其余位是0的数 即1010 -> 0010

2.选择排序：通过双层循环，找到更小的数和i位置的数进行交换
> 时间复杂度：O(n^2)
>
> ​		第一次遍历：n-1次，第一次比较：n-1 第一次交换：一次
>
> ​		第二次遍历：n-2次，第二次比较：n-2 第一次交换：一次
>
> ​		根据通项公式求和，结果是 an^2 + bn + c，所以时间复杂度就是O(n^2)
>
> 空间复杂度：O(1)
>
> ​		空间复杂度和n没有关系，只是常量级别的额外空间，所以是O(1)

3.冒泡排序：通过双层循环，相邻的两个数比较交换
> 时间复杂度：O(n^2)
>
> ​		第一次遍历：n-1次，第一次比较：n-1 第一次交换：一次
>
> ​		第二次遍历：n-2次，第二次比较：n-2 第一次交换：一次
>
> ​		根据通项公式求和，结果是 an^2 + bn + c，所以时间复杂度就是O(n^2)
>
> 空间复杂度：O(1)
>
> ​		空间复杂度和n没有关系，只是常量级别的额外空间，所以是O(1)

4.插入排序：依次遍历数组，当前数一直和左边的数比较，比它小的话交换，大或者没数停止
> 时间复杂度：O(n^2) 
>
> ​		[1, 5, 3, 6, 2]
>
> ​		第一次遍历：0位置和0位置比较，比较1次，不用交换
>
> ​		第二次遍历：0-1位置 比较1次，不用交换
>
> ​		第三次遍历：0-2位置  3和5比较交换，3和1比较不交换，比较2次，交换1次
>
> ​		但是存在一种情况，[1,2,3,4]数组本身就是有序的，只需比较不交换，这种时间复杂度就是O(n)，
>
> ​		最坏情况下每次[4,3,2,1]就是等差数列，时间复杂度就是O(n^2)
>
> ​		按照时间复杂度定义，取最坏的情况，插入排序时间复杂度就是O(n^2)
>
> 空间复杂度：O(1)
>
> ​		空间复杂度和n没有关系，只是常量级别的额外空间，所以是O(1)

5.归并排序：将数组分成两部分，两部分分别排序，两部分分别从0开始遍历比较，较小的优先放入新数组。

- 整体就是一个简单的递归，左边排好序、右边排好序、让其整体有序
- 让其整体有序的过程里用了外排序方法
- 利用master公式来求解时间复杂度

> 时间复杂度 O(N*logN)
>
> 额外空间复杂度 O(N)
>
> [3, 2, 4, 8, 7, 2]  ----> 分成两部分排序，[2, 3, 4] [2, 7, 8]
>
> 比较0索引和mid位置大小，2放入新数组，比较1索引和mid位置大小，mid位置2放入新数组，比较索引1和mid+1位置大小，2索引位置3放入新数组，依次.....
## 四、二分法：一次砍一半 一次砍一半 砍几次 

1.时间复杂度：O(logN)
- 有序数组是否存在某个数： 底数默认2
- 有序数组找大于num最左侧的索引位置，时间复杂度：O(logN)
- 无序且数不相等数组，找任意一个局部最大值（如果0位置比1位置大，或者如果n比n-1位置数大，或者i比i-1大且比i+1大，符合任意一种就是局部最小值）

## 五、对数器
1.简单来讲，就是生成随机长度数组，随机值的数组中数，分别放入两段代码执行，最终两个数组一一比对，不对，那么两段代码可能都有问题

## 六、递归时间复杂度
1.master公式：T(N) =              a                    *     T(N/b)  +  O(N^d); 

​                           母问题   a表示子问题调用次数   子问题     除了子问题外的时间复杂度

```java
/**
 * 子问题调用的次数，即search中调用了两次search方法，a=2
 * 每次调用都是二分，所以b=2
 * 除了子问题外，只有一个比较return，还有一个mid求值，是常量级别的
 * 所以master公式：T(N) = 2*T(N/2) + O(1); 
 */
public static int search(int[] arr, int l, int r) {
        //两种特殊情况
        if (l == r) {
            return arr[l];
        }

        //取中点 由于l+r有可能越界，所以采用 r-l除以2 + l的写法
        int mid = l + ((r - l) >> 1);
        int leftMax = search(arr, l, mid);
        int rightMax = search(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
}
```
