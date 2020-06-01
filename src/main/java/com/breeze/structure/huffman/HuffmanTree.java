package com.breeze.structure.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : breeze
 * @date : 2020/6/1
 * @description : 赫夫曼树
 *
 *  1.基本介绍：
 *      给定n个权值作为n个叶子节点(即有n个节点，每个节点都有值)，构造一个二叉树
 *      若该树的带权路径长度(WPL)达到最小，称这样的二叉树为最优二叉树，也称赫夫曼树
 *  2.赫夫曼树的带权路径长度最短，权值较大的节点离根较近
 *  3.路径：在一棵树中，从一个节点往下可以达到的孩子或孙子节点之间的通路
 *  4.路径长度：根节点到第L层节点的路径长度是L-1，即树高是3，那么根节点到最下层叶子节点的路径长度是3-1=2
 *  5.节点的权：若将书中节点赋给一个有着某种含义的数值，则这个数值称为该节点的权
 *  6.节点的带权路径长度：从根节点到该节点之间的路径长度与该节点的权的乘积
 *  7.树的带权路径长度：树的带权路径长度规定为所有叶子节点的带权路径长度之和，记作WPL，
 *      权值越大的节点离根节点越近的二叉树才是最优二叉树
 *  8.WPL最小的二叉树就是赫夫曼树
 *
 *  9.构建赫夫曼树的步骤：
 *      1）从小到大进行排序，每个数据都是一个节点，每个节点可以看成是一棵最简单的二叉树
 *      2）取出根节点权值最小的两颗二叉树
 *      3）组成一棵新的二叉树，这个新二叉树的根节点的权值是前面两棵二叉树根节点权值之和
 *      4）再将这棵新的二叉树，以根节点的权值大小再次排序，不断重复1234步骤，直到数列中
 *          所有的数据都被处理，就得到一棵赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    /**
     * 前序遍历
     * @param root 赫夫曼树根节点
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历！");
        }
    }

    /**
     * 创建赫夫曼树
     * @param arr 数组
     * @return 创建好后的赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr) {
        // 1.为了方便操作，遍历arr数组
        // 2.将arr的每个元素构成成一个Node
        // 3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);

            //取出根节点权值最小的两棵二叉树
            //1.取出权值最小的节点（二叉树）
            Node leftNode = nodes.get(0);
            //2.取出权值第二小的节点
            Node rightNode = nodes.get(1);

            //3.构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //4.冲ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //5.将parent加入nodes
            nodes.add(parent);

            //6.重新排序
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }
}
