package com.breeze.structure.hash;

import javax.naming.Name;
import java.util.Scanner;

/**
 * @author breeze
 * @date 2020/4/1
 *
 *  谷歌面试题：
 *       有一个公司，当有新员工来报道，要求该员工的信息加入id
 *   姓名，性别，年龄，住址...当输入该员工的id时候，要求查找到
 *   该员工的所有信息
 */
public class HashableDemo {
    public static void main(String[] args) {

        //创建hash表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单测试
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("f: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "f":
                    System.out.println("请输入要查找的id：");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    System.out.println("退出系统！");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
