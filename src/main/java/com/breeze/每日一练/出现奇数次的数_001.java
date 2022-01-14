package com.breeze.每日一练;

/**
 * @author : breeze
 * @date : 2022/1/13
 * @desc : 1.数组中，只有一个数出现了奇数次，其他数都出现了偶数次，问奇数次的数是什么？
 * @desc : 2.数组中，只有二个数出现了奇数次，其他数都出现了偶数次，问奇数次的数是什么？
 */
public class 出现奇数次的数_001 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 5};
        // select1(arr);
        select2(arr);
    }

    /**
     * 存在一个数a出现奇数次
     * 思路：每个数相互异或，偶数次的数相互异或结果是0，结果就是a
     * @param arr
     */
    public static void select1(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
    }

    /**
     * 存在两个数ab出现奇数次
     * 思路：
     *  1.每个数相互异或，结果result就是a^b值，且a != b 且result != 0
     *  2.由于result不等于0，result二进制表示数中肯定有一位不为0，我们假设第8位为不为0的位置
     *      再假设 a第八位是1，b的第八位就是0。按照这个思路我们可以将数组中的数的第八位二进制进行分组
     *  3.一种是第八位是1的数组成的数组arr1，一种是第八位是0的数组成的数组arr0，
     *      arr1相互异或得到a的第八位的二进制，arr0相互异或得到b的第八位的二进制
     *  4.所以只要遍历每个数的二进制的每个位数，分组相互异或就可以推导出ab的二进制位值
     * @param arr
     */
    public static void select2(int[] arr) {
        int result = 0;
        for (int cur : arr) {
            result ^= cur;
        }
        //假设result最右侧为1的索引是i
        int rightOne = result & (~result + 1);
        int a = 0;
        for (int cur : arr) {
            //分组，
            if ((cur & rightOne) == 0) {
                a ^= cur;
            }
        }
        System.out.println(result);
        System.out.println(a);
        System.out.println(result ^ a);
    }
}
