package com.breeze.structure.tree;

import lombok.Data;

/**
 * @author breeze
 * @date 2020/4/7
 *
 *  线索二叉树：
 *      1.n个节点的二叉链表中含有n+1 [2n-(n-1)=n+1]个空指针域
 *  利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前
 *  驱和后继节点的指针(这种附加的指针称为"线索")
 *      2.打个比方，1,3,6,8,10,14 中序遍历是：8,3,10,1,6,14
 *  那么8的节点指向3的这个过程就叫线索化
 *      3.这种加上了线索的二叉链表称为线索链表，相应的二叉树称为
 *  线索二叉树(threaded binaryTree)，根据线索性质的不同，线索
 *  二叉树可以分为前序线索二叉树，中序线索二叉树，后序线索二叉树
 *      4.一个节点的前一个节点，称为前驱节点
 *      5.一个节点的后一个节点，称为后继节点
 *
 *  案例：
 *      1.将下面的二叉树，进行中序线索二叉树，中序遍历的数列为
 *          [8,3,10,1,6,14]
 */
@Data
public class ThreadedBinaryTree {

    //根节点
    private HeroNode root;
    //为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    /**
     * 遍历线索化二叉树的方法
     */
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环找到leftType == 1 的节点
            //node后面随着遍历而变化，因为当leftType == 1时，
            //说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的后指针指向后续节点，就一直输出
            while (node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            //替换遍历的节点
            node = node.getRight();
        }
    }


    /**
     * 重载
     */
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     * @param node
     */
    public void threadedNodes(HeroNode node) {
        //如果node==null，就不能线索化
        if (node == null) {
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());

        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理当前节点的后继节点，需要再下个节点（下次递归）的时候设置
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }

        //没处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());

    }

    /**
     * 前序遍历查找
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历查找
     * @param no
     * @return
     */
    public HeroNode midOrderSearch(int no) {
        if (root != null) {
            return root.midOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 后序遍历查找
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 删除节点
     * @param no
     */
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root节点，立即判断root是不是要删除节点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除！");
        }
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     *
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }
}
