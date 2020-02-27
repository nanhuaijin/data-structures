package com.breeze.stack.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author breeze
 * @date 2020/2/27
 * <p>
 * 中缀表达式转后缀表达式思路分析：
 *      1.初始化两个栈，运算符栈 s1 和储存中间结果的栈 s2
 *      2.从左到右扫描中缀表达式
 *      3.遇到操作数时，将其压入s2
 *      4.遇到运算符的时候，比较其与s1栈顶运算符的优先级：
 *          1)如果 s1 为空，或栈顶运算符为左括号 “(”，则直接将此运算符入栈
 *          2)否则，若优先级比栈顶运算符要高，也直接入栈
 *          3)否则，将 s1 栈顶的运算符弹出并压入到s2中，再次转到步骤4-1与
 *            s1中新的栈顶运算符相比较
 *      5.遇到括号时：
 *          1)如果是左括号，则直接压入s1
 *          2)如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止
 *            此时将这对括号丢掉
 *      6.重复步骤2至5，直到表达式的最右边
 *      7.将s1中剩余的运算符依次弹出并压入s2
 *      8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class InfixConvertSuffix {
    public static void main(String[] args) {

        //1+((2+3)*4)-5  -->  123+4*+5-
        String expression = "1+((2+3)*4)-5";

        //因为直接操作字符串不方便，所以将中缀表达式存入相应的list中
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);

        //将中缀表达式对应的list转成后缀表达式对应的list
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        suffixExpressionList.forEach(System.out::print);

        System.out.println("最后的结果是：" + PolandNotation.calculate(suffixExpressionList));
    }

    /**
     * 将中缀表达式对应的list转成后缀表达式对应的list
     * @param list 中缀表达式对应的list
     * @return 后缀表达式对应的list
     */
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        Stack<String> stack = new Stack<>(); //符号栈
        //说明：因为s2这个栈没有pop操作，之后还需要逆序输出，所以直接用list
        List<String> result = new ArrayList<>();

        //遍历list
        for (String item : list) {
            //如果是一个数字，就加入到result
            if (item.matches("\\d+")) {
                result.add(item);
            } else if ("(".equals(item)) {
                stack.push(item);
            } else if (")".equals(item)) {
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，
                // 直到遇到左括号为止,此时将这对括号丢掉
                while (!"(".equals(stack.peek())) {
                    result.add(stack.pop());
                }
                //将左括号 "(" 弹出stack栈 ，消除小括号
                stack.pop();
            } else {
                //当 item 的优先级小于等于 栈顶的优先级
                // 将 s1 栈顶的运算符弹出并压入到s2中，
                // 再次转到步骤4-1与s1中新的栈顶运算符相比较
                while (stack.size() != 0 && getPriority(stack.peek()) >= getPriority(item)) {
                    result.add(stack.pop());
                }
                //还需要将item压入stack栈中
                stack.push(item);
            }
        }
        //将stack中剩余的运算符依次弹出加入到result中
        while (stack.size() != 0) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 返回运算符的优先级
     * @param operation
     * @return
     */
    public static int getPriority(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
            case "-":
                result = 1;
                break;
            case "*":
            case "/":
                result = 2;
                break;
            default:
                System.out.println("运算符有误！");
        }
        return result;
    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String expression) {
        //定义一个list存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        //指针，用于遍历中缀表达式字符串
        int index = 0;
        //对多位数的拼接
        String str;
        char c; //每遍历到一个字符，直接放入c

        do {
            //如果c是一个非数字，就需要加入到list中
            if ((c = expression.charAt(index)) < 48 || (c = expression.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {
                //如果是一个数，需要考虑多位数的问题
                //先将str置空
                str = "";
                while (index < expression.length()
                        && (c = expression.charAt(index)) >= 48
                        && (c = expression.charAt(index)) <= 57) {
                    str += c; //拼接
                    index++;
                }
                list.add(str);
            }
        } while (index < expression.length());
        return list;
    }
}
