package com.breeze.structure.stack.linkedlist;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 使用链表模拟栈
 */
public class LinkedListStack {
    private int maxSize;
    private int top = -1;
    private SingleLinkedList stack;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new SingleLinkedList();
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        SingleLinkedList.reverse(stack.getHead());
        top++;
        stack.add(new Node(value));
    }

    //出栈  将栈顶的数据返回
    public int pop() {
        //先进行链表的反转
        SingleLinkedList.reverse(stack.getHead());

        Node next = stack.getHead();
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        while (true) {
            if (next.getNext().getNext() == null) {
                top--;
                Integer no = next.getNext().getNo();
                next.setNext(null);
                return no;
            }
            next = next.getNext();
        }
    }

    //遍历栈 -- 遍历时，需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }

        SingleLinkedList.reverse(stack.getHead());
        stack.list();
    }
}
