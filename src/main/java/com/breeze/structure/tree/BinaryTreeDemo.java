package com.breeze.structure.tree;

/**
 * @author breeze
 * @date 2020/4/4
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        //创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "机器猫");

        //说明：我们先手动创建二叉树，后面再递归创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.midOrder();
        System.out.println("后序遍历：");
        binaryTree.postOrder();
    }
}
