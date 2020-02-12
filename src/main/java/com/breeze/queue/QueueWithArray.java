package com.breeze.queue;

import java.util.Scanner;

/**
 * @author breeze
 * @date 2020/2/12
 * 使用数组实现队列 - 问题
 *      1.数组不能重复使用，因为不是一个环形队列
 *      2.显示队列的时候没有将取出的数据从数组中删除
 */
public class QueueWithArray {
    public static void main(String[] args) {
        //测试 - 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("=========================");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("=========================");
            System.out.print("请输入对应的字母：");
            key = scanner.next().charAt(0); // 接收一个字符

            switch (key) {
                case 's': //显示队列
                    arrayQueue.showQueue();
                    break;
                case 'a': //添加数据到队列
                    System.out.print("请输入一个数字：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g': //从队列中取出数据
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("===程序退出===");
    }
}

/**
 * 使用数组模拟队列 - 编写一个ArrayQueue类
 */
class ArrayQueue{

    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾，指向队列尾的具体的数据(就是队列最后一个数据)
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列，进队列
     * @param n
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据！");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++; //front后移
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     * @return
     */
    public int headQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front + 1];
    }

}