package com.breeze.structure.linkedlist.doublee;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 双向链表CRUD分析：
 *      1.遍历方式和单链表一样，只是可以向前，也可以向后
 *      2.添加(默认添加到双向链表的最后)
 *          1)先找到双向链表的最后的这个节点temp
 *          2)temp.next = newHeroNode
 *          3)newHeroNode.pre = temp
 *      3.修改的思路和原理 同单链表一样
 *      4.删除
 *          1)因为是双向链表，因此可以实现自我删除某个节点
 *          2)直接找到要删除的这个节点，比如temp
 *          3)temp.pre.next = temp.next
 *          4)temp.next.pre = temp.pre
 */
public class DoubleLinkedList {

    //先初始化一个头节点，头节点不要动
    private Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * 添加节点到双向链表
     * 思路，当不考虑编号顺序时
     *      1.找到当前链表的最后节点
     *      2.将最后这个节点的next指向新的节点
     * @param node
     */
    public void add(Node node) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        Node temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环的时候，temp指向链表的最后
        //将最后这个节点的next指向新的节点，并将新的节点的pre指向temp节点
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 第二种添加英雄的方式，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败，并给出提示
     * @param node
     */
    public void addByOrder(Node node) {
        //因为头节点不能动，因此我们任然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        Node temp = head;
        boolean flag = false; //标志添加的编号是否存在，默认是false
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > node.no) {
                break;
            } else if (temp.no == node.no) {//说明希望添加的HeroNode的编号已经存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            System.out.printf("待插入的英雄的编号 %d 已经存在了，不能添加\n", node.no);
        } else {
            //插入到链表中，temp后面
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            //当链表不为空的时候才可以执行这句话
            if (node.next != null) {
                node.next.pre = node;
            }
        }
    }

    /**
     * 根据节点的信息，根据no编号进行修改，即no编号不能改
     */
    public void update(Node node){
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        Node temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", node.no);
        }
    }

    /**
     * 根据no删除节点
     * 对于双向链表，可以直接找到要删除的节点，自我删除
     * 被删除的节点将不会有其他引用指向，会被垃圾回收机制回收
     */
    public void delete(int no) {

        if (head.next == null) {
            System.out.println("链表为空无法删除!");
            return;
        }

        Node temp = head.next; //辅助指针
        boolean flag = false; // 标识是否找到待删除的节点的前一个节点
        while (true) {
            //
            if (temp == null) {
                break;
            }
            //找到待删除的节点的前一个节点
            if (temp.no == no) {
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }

        if (flag) {
            //可以删除
            temp.pre.next = temp.next;
            //这里会有一个问题，如果是最后一个节点，就不需要执行下面的这句话，否则会报空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的节点 %d 不存在！\n", no);
        }
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空、
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能动，因此我们需要辅助变量来遍历
        Node temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp.next == null) {
                System.out.println(temp);
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}
