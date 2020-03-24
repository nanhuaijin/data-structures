package com.breeze.structure.stack.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author breeze
 * @date 2020/2/27
 *
 *  我们要完成一个逆波兰计算器
 *      1.输入一个逆波兰表达式(后缀表达式)，使用栈，计算其结果
 *      2.支持小括号和多位数的整数，因此这里我们主要讲的是数据结构，
 *        因为计算器进行简化，只支持整数
 *
 *  补充：parseInt() 和 valueOf() 区别
 *      1、返回值不同
 *         parseInt 返回值是int型
 *         valueOf	返回值是Integer型
 *      2、valueOf就是调用了parseInt方法的
 *      3、parseInt效率比valueOf效率高
 */
public class PolandNotation {
    public static void main(String[] args) {

        //先定义一个逆波兰表达式 (3+4)*5-6 --> 34+5*6-
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 * 6 - ";
        //1.先将suffixExpression放入ArrayList中
        List<String> list = getListString(suffixExpression);

        //2.将 ArrayList 传递给一个方法配合栈 完成计算
        int result = calculate(list);
        System.out.printf("计算结果是: %d\n", result);
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //使用正则表达式来取出数
            if (item.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //如果是运算符，pop出两个数进行运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result;

                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误！");
                }
                stack.push(result + "");
            }
        }
        //最后留在栈中的数据就是结果
        return Integer.parseInt(stack.pop());
    }
}
