package com.breeze.structure.tree;

/**
 * @author breeze
 * @date 2020/4/7
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        //创建节点
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node1 = new HeroNode(3, "jack");
        HeroNode node2 = new HeroNode(6, "smith");
        HeroNode node3 = new HeroNode(8, "mary");
        HeroNode node4 = new HeroNode(10, "king");
        HeroNode node5 = new HeroNode(14, "dim");

        //二叉树，后面我们需要递归创建，现在手动
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        //测试中序线索二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试 10号
        HeroNode node4Left = node4.getLeft();
        HeroNode node4Right = node4.getRight();
        System.out.println("10号节点的前驱节点：" + node4Left);
        System.out.println("10号节点的后继节点：" + node4Right);
    }
}
