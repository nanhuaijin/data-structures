package com.breeze.structure.recursion;

/**
 * @author breeze
 * @date 2020/3/8
 * 八皇后问题 - 回溯法
 *      1.第一个皇后先放第一行第一列
 *      2.第二个皇后放在第二行第一列，然后判断是否OK。
 *        如果不OK，继续放第二列、第三列，依次把所有列都放完，找到一个合适的
 *      3.继续第三个皇后，还是第一列、第二列...知道第8个皇后也能放在一个
 *        不冲突的位置，就算是找到了一个正确解，全部得到
 *      4.当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后
 *        放到第一列的所有正确解，全部得到
 *      5.然后回头继续第一个皇后放第二列，后面继续循环执行1234的步骤
 * 说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法
 *      用一个一位数组即可以解决问题
 *
 */
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如 arr = [0,4,7,5,2,6,1,3]
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 backtrackingMethod = new Queen8();
        backtrackingMethod.check(0);
        System.out.println("一共有：" + count + " 种解法");
    }

    //编写一个方法，防止第n个皇后
    //特别注意：每次递归一个check都有一个for循环
    private void check(int n) {
        if (n == max) {
            //n = 8，其实8个皇后就已经放好了
            print();
            return;
        }
        //如果没有就一次放入，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突，接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果不冲突，就继续执行array[n] = i,即将第n个皇后，放置在本行的后移一个位置

        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1，array[i] == array[n] 表示din个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i])判断第n个皇后是否和第i个皇后在同一斜线
            if (array[i] == array[n]
                    || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后的位置输出
    private void print() {
        count++;
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
