package com.breeze.stack.linkedlist;

import java.util.Scanner;

/**
 * @author breeze
 * @date 2020/2/26
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {

        //测试LinkedListStack
        LinkedListStack stack = new LinkedListStack(4);
        String key = "";
        boolean loop = true; //是否退出菜单

        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("========================");
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");
            System.out.println("============================");
            System.out.print("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("出栈的数据是：" + result);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
