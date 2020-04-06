package com.breeze.structure.tree;

/**
 * @author breeze
 * @date 2020/4/6
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        //创建ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
        System.out.println();
        arrBinaryTree.preOrder();
    }
}
