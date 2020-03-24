package com.breeze.structure.linkedlist.doublee;

/**
 * @author breeze
 * @date 2020/2/26
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //创建节点进行测试
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");
        Node hero5 = new Node(5, "鲁智深", "花和尚");
        Node hero6 = new Node(6, "武松", "行者");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //测试双向链表的普通添加
        //doubleLinkedList.add(hero1);
        //doubleLinkedList.add(hero2);
        //doubleLinkedList.add(hero3);
        //doubleLinkedList.add(hero4);
        //doubleLinkedList.add(hero6);
        //doubleLinkedList.add(hero5);

        //测试双向链表的按照顺序添加
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero6);
        doubleLinkedList.addByOrder(hero5);

        System.out.println("添加后的链表：");
        doubleLinkedList.list();

        //测试双向链表的修改
        Node hero = new Node(5, "鲁路修", "宠妹狂魔");
        doubleLinkedList.update(hero);
        System.out.println("修改后的链表：");
        doubleLinkedList.list();

        //测试双向链表的删除
        doubleLinkedList.delete(6);
        System.out.println("删除后的链表：");
        doubleLinkedList.list();

    }
}
