package com.breeze.structure.stack.application;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 使用数组模拟栈 -- 加强版 判断运算符优先级
 *
 */
public class ArrayStackPlus {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据放在该数组中
    private int top = -1; //栈顶

    public ArrayStackPlus(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 返回运算符的优先级，优先级是程序员来确定的
     * 数字越大优先级越大
     * @param opera
     * @return
     */
    public int priority(int opera) {
        if (opera == '*' || opera == '/') {
            return 1;
        } else if (opera == '+' || opera == '-') {
            return 0;
        } else {
            return -1; //假定目前的表达式只有 +-*/
        }
    }

    /**
     * 判断是不是运算符
     * @param val
     * @return
     */
    public boolean isOpera(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     * @param n1
     * @param n2
     * @param opera
     * @return
     */
    public int cal(int n1, int n2, int opera) {
        //用于存放计算结果
        int result = 0;
        switch (opera) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n2 - n1;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n2 / n1;
                break;
            default:
                break;
        }
        return result;
    }

    //增加一个方法，可以查看栈顶的数据
    public int peek() {
        return stack[top];
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
