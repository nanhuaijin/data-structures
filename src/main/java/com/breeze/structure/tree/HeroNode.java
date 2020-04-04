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
     * 前序遍历查找
     * @param no 查找no
     * @return 如果找到返回该node，否则返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序");
        //先比较当前节点是不是目标节点
        if (this.no == no) {
            return this;
        }
        //则判断当前节点的左子节点是否为空，不为空递归查找
        //找到就返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        //说明左子树找到了
        if (resNode != null) {
            return resNode;
        }

        //递归向右子树前序遍历
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public HeroNode midOrderSearch(int no) {
        //1.先判断当前节点的左子节点是否为空，不为空继续中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序");
        if (this.no == no) {
            return this;
        }

        //递归向右子树中序遍历
        if (this.right != null) {
            resNode = this.right.midOrderSearch(no);
        }

        return resNode;
    }

    /**
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }

        if (resNode != null) {//说明在左子树找到了
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null) {//说明在右子树找到了
            return resNode;
        }
        System.out.println("后序");
        //如果左右子树都没有找到，就比较当前节点
        if (this.no == no) {
            return this;
        }

        return resNode;
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
