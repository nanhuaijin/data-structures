package com.breeze.structure.tree;

import lombok.Data;

/**
 * @author breeze
 * @date 2020/4/4
 *
 *  先创建节点
 */
@Data
public class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }

        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出父节点
        System.out.println(this);

        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
