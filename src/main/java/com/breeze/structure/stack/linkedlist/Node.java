package com.breeze.structure.stack.linkedlist;

import lombok.Data;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 链表的节点
 */
@Data
public class Node {
    private Integer no;
    private Node next;

    public Node(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
