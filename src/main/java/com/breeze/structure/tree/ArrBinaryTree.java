package com.breeze.structure.tree;

import lombok.AllArgsConstructor;

/**
 * @author breeze
 * @date 2020/4/6
 *
 *  编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
 *  顺序存储二叉树：即 一个数组，但是遍历要以二叉树的前中后序遍历实现
 *          树 --->  可以转成数组
 *          数组 --->  可以转成数
 *
 *      1.顺序二叉树通常只考虑完全二叉树
 *      2.第n个元素的左子节点为 2*n+1
 *      3.第n个元素的右子节点为 2*n+2
 *      4.第n个元素的父节点为 (n-1)/2
 *
 *      5.n表示的是元素在数组中的索引
 *
 */
@AllArgsConstructor
public class ArrBinaryTree {

    private int[] arr; //存储数据节点的数组

    /**
     * 重载前序遍历
     */
    public void preOrder() {
        this.preOrder(0);
    }



    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     * @param index  数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历！");
        }

        //输出当前这个元素
        System.out.print(arr[index] + "\t");
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }


}
