package com.breeze.stack.array;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 使用数组模拟栈
 *
 * 栈 -- 先进后出
 *      1.top表示栈顶，初始值为 -1
 *      2.入栈操作，当有数据加入栈时，top++; stack[top] = data;
 *      3.出栈操作，int value = stack[top]; top--; return value;
 */
public class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据放在该数组中
    private int top = -1; //栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈  将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈 -- 遍历时，需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
