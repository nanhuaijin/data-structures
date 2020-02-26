package com.breeze.linkedlist.single;

import java.util.Stack;

/**
 * @author breeze
 * @date 2020/2/16
 * 使用带head头的单向链表，实现水浒英雄排行榜
 *      1.第一种在添加英雄的时候直接添加到链表的尾部
 *      2.第二种方式在添加英雄的时候，将英雄插入的指定的位置(如果有这个排名则添加失败，给出提示)
 *
 * 单链表常见的面试题(新浪、百度、腾讯):
 *      1.求单链表中有效节点的个数
 *      2.查找单链表中倒数第k个节点【新浪】
 *      3.单链表的反转【腾讯】
 *      4.从尾到头打印单链表【百度 要求方式一：反向遍历  方式二：stack栈】
 *      5.合并两个有序的单链表，合并之后的链表依然有效
 *
 * 单向链表存在的问题：
 *      1.查找的方向只能是一个方向
 *      2.单向链表不能自我删除，要靠辅助节点，需要找到待删除节点的前一个节点进行辅助删除
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //进行测试
        //1.先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "鲁智深", "花和尚");
        HeroNode hero6 = new HeroNode(6, "武松", "行者");

        //创建单向链表,添加
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);

        //测试按照顺序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);

        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero5);

        //测试合并两个有序链表
        singleLinkedList.mergeTwoList(singleLinkedList2);
        System.out.println("合并后的链表是：");
        singleLinkedList.list();

        //打印
        System.out.println("修改前的链表");
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表");
        singleLinkedList.list();

        //测试删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);

        //打印
        System.out.println("删除后的链表");
        singleLinkedList.list();

        //测试单链表的有效节点的个数
        System.out.println("有效的节点个数：" + getLength(singleLinkedList.getHead()));

        //查找单链表中倒数第k个节点【新浪】
        HeroNode heroNode = findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("倒数第K个节点是：" + (heroNode==null ? "不存在":heroNode));

        //测试单链表的反转
        reverse(singleLinkedList.getHead());
        System.out.println("反转后的链表");
        singleLinkedList.list();

        //测试从尾到头打印单链表
        System.out.println("Stack实现的逆序打印的单链表");
        reversePrint(singleLinkedList.getHead());
    }

    /**
     * 从尾到头打印单链表【百度 要求方式一：反向遍历  方式二：stack栈】
     *      方式一：
     *          1.先将单链表反转，再逆序打印(这样做的问题是，会破坏原来单链表的结构)  不建议
     *      方式二：
     *          1.可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印
     * @param head 头节点
     */
    public static void reversePrint(HeroNode head) {
        //空链表，不能打印
        if (head.next == null) {
            return;
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode current = head.next;
        //将链表的所有节点压入栈中
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        //将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 单链表的反转【腾讯】
     *      思路：1.先定义一个节点reverseHead = new HeroNode();
     *           2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放到新的链表的最前端
     *           3.原来的链表的head.next = reverseHead.next
     * @param head 头节点
     */
    public static void reverse(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode current = head.next;
        //指向当前节点[current]的下一个节点
        HeroNode next = null;
        //定义一个头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点就将它取出
        while (current != null) {
            //先暂时保存当前节点的下一个节点
            next = current.next;
            //将reverseHead的下一个节点赋值给current的下一个
            current.next = reverseHead.next;
            //将当前的节点放置在reverseHead.next的位置
            reverseHead.next = current;
            //让current后移
            current = next;
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中倒数第k个节点【新浪】
     *      思路：1.先把链表从头到尾遍历，得到链表的总的长度getLength
     *           2.得到size后，我们从链表的第一个开始遍历(size-index)个就可以得到
     *           3.找到了就返回，找不到返回null
     * @param head 头节点
     * @param index 倒数第几个节点
     * @return 返回这个节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //如果链表为空，返回null
        if (head.next == null) {
            return null;
        }

        //第一个遍历得到链表的长度
        int size = getLength(head);

        //第二次遍历，size-index 位置，就是我们倒数的第K个节点
        if (index <= 0 || index > size) {
            return null;
        }

        //定义一个辅助变量, for循环定义到倒数的index
        HeroNode current = head.next;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 获取单链表的有效节点的个数(如果是带头节点的链表，不需要统计头节点)
     * @param head 链表的头节点
     * @return 返回的是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        //空链表
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量，这里没有统计头节点
        HeroNode current = head.next;
        while (current != null) {
            length++;
            //遍历
            current = current.next;
        }
        return length;
    }
}
