package com.breeze.structure.tree;

import lombok.Data;

/**
 * @author breeze
 * @date 2020/4/1
 *
 *  二叉树：
 *      1.为什么需要：
 *        ① 数组存储方式的分析
 *          优点：通过下标方式访问元素，速度快，对于有序数组，还可以
 *                使用二分查找提高检索速度
 *          缺点：如果要检索某个值，或者插入值(按照一定的顺序)会整体
 *                移动，效率低
 *        ② 链表存储方式分析
 *          优点：在一定程度对数组存储方式有优化。比如：插入一个数值
 *                节点，只需要将插入节点，链接到链表中即可，删除效率也很好
 *          缺点：在进行检索时，效率仍然较低。比如：检索某个值，需要
 *                从头节点开始遍历
 *        ③ 树存储方式的分析
 *          能提交数据存储，读取的效率。比如利用二叉排序树，既可以
 *          保证数据的检索速度，同时也可以保证数据插入，删除，修改的速度
 *      2.概念：每个节点最多只能有两个子节点的一种形式称为二叉树
 *      3.前序遍历：先输出父节点，再遍历左子树和右子树
 *      4.中序遍历：先遍历左子树，再输出父节点，再遍历右子树
 *      5.后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 *      6.看输出父节点的顺序，就能确定是前序中序还是后序
 */
@Data
public class BinaryTree {
    //根节点
    private HeroNode root;

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
