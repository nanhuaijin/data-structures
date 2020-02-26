package com.breeze.stack.linkedlist;

import lombok.Getter;
import lombok.Setter;

/**
 * @author breeze
 * @date 2020/2/26
 * <p>
 * 单向链表
 */
public class SingleLinkedList {
    //设置头节点
    @Getter
    @Setter
    private Node head = new Node(null);

    public static void reverse(Node head){
        //如果当前链表为空，或者只有一个节点，无需反转直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }

        //定义一个辅助的指针，帮助我们遍历原来的链表
        Node current = head.getNext();
        //指向当前节点[current]的下一个节点
        Node next = null;
        //定义一个头节点
        Node reverseHead = new Node(null);
        //遍历原来的链表，每遍历一个节点就将它取出
        while (current != null) {
            //先暂时保存当前节点的下一个节点
            next = current.getNext();
            //将reverseHead的下一个节点赋值给current的下一个
            current.setNext(reverseHead.getNext());
            //将当前的节点放置在reverseHead.next的位置
            reverseHead.setNext(current);
            //让current后移
            current = next;
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.setNext(reverseHead.getNext());
    }

    public void add(Node node) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        Node temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.getNext() == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.getNext();
        }
        //当退出while循环的时候，temp指向链表的最后
        //将最后这个节点的next指向新的节点
        temp.setNext(node);
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空、
        if (head.getNext()== null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能动，因此我们需要辅助变量来遍历
        Node temp = head.getNext();
        while (true) {
            //判断是否到链表最后
            if (temp.getNext() == null) {
                System.out.println(temp);
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.getNext();
        }
    }
}
