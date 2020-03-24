package com.breeze.structure.queue;

import java.util.Scanner;

/**
 * @author breeze
 * @date 2020/2/13
 * 数组模拟环形队列
 */
public class CircularQueueWithArray {
    public static void main(String[] args) {
        //测试 - 创建一个队列，设置4，其队列的有效数据最大是3
        CircularArrayQueue arrayQueue = new CircularArrayQueue(4);
        char key; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("====测试数组模拟环形队列====");
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
class CircularArrayQueue{

    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * front就是指向队列的第一个元素，也就是说arr[front]
     * 就是队列的第一个元素，front的初始值为0
     */
    private int front;
    /**
     * rear指向队列的最后一个元素的后一个位置，因为希望空出
     * 一个空间作为约定，rear初始值为0
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
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
        //这是需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保存到一个临时的变量中
        int value = arr[front];
        //2.将front后移，考虑取模
        front = (front + 1) % maxSize;
        //3.将临时的变量返回
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~");
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
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
        return arr[front];
    }

}