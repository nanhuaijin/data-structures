package com.breeze.structure.linkedlist.single;

/**
 * @author breeze
 * @date 2020/2/25
 * 定义SingleLinkedList 管理我们的英雄
 */
public class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     *  合并两个有序的单链表，合并之后的链表依然有效
     * @param s1 待合并的链表
     */
    public void mergeTwoList(SingleLinkedList s1) {
        HeroNode head = this.getHead();
        HeroNode h1 = this.getHead().next;
        HeroNode h2 = s1.getHead().next;

        while (h1 != null && h2 != null) {
            if (h1.no >= h2.no) {
                head.next = h2;
                h2 = h2.next;
            } else {
                head.next = h1;
                h1 = h1.next;
            }
            head = head.next;
        }

        if (h1 != null) {
            head.next = h1;
        }

        if (h2 != null) {
            head.next = h2;
        }
    }

    /**
     * 添加节点到单向链表
     * 当不考虑编号排序时
     *  1.找到当前链表的最后节点
     *  2.将最后这个节点的next 指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    /**
     * 第二种添加英雄的方式，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败，并给出提示
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们任然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //标志添加的编号是否存在，默认是false
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的HeroNode的编号已经存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            System.out.printf("待插入的英雄的编号 %d 已经存在了，不能添加\n", heroNode.no);
        } else {
            //插入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据节点的信息，根据no编号进行修改，即no编号不能改
     */
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 根据no删除节点
     * 需要先找到需要删除的节点的前一个节点
     * 被删除的节点将不会有其他引用指向，会被垃圾回收机制回收
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标识是否找到待删除的节点的前一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //找到待删除的节点的前一个节点
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }

        if (flag) {
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点 %d 不存在！\n", no);
        }
    }

    /**
     * 显示链表(遍历)
     */
    public void  list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点， 不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}
