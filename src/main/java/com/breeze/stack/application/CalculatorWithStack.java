package com.breeze.stack.application;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 使用栈模拟计算器，实现一个表达式的计算结果
 *  7 * 2 * 2 - 5 + 1 - 5 + 3 - 4 = ？
 *
 *  分析思路：
 *      1.通过一个index值(索引)，来遍历我们的表达式
 *      2.如果我们发现是一个数字，就直接加入到数栈(numStack)中
 *      3.如果发现扫描到的是一个符号，就分如下情况
 *          3.1.如果发现当前的符号栈(operaStack)为空，就直接入栈
 *          3.2.如果符号栈有运算符，就进行比较，如果当前的运算符的优先级
 *              小于或者等于栈中的运算符，就需要从数栈中pop出两个数，再从
 *              符号栈中pop出一个符号，进行运算，将得到的结果，入数栈，
 *              然后将当前的操作符入符号栈
 *          3.3.如果当前的运算符的优先级大于栈中的运算符，就直接入符号栈
 *      4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，
 *        并运行
 *      5.最后在数栈只有一个数字，就是表达式的结果
 */
public class CalculatorWithStack {
    public static void main(String[] args) {
        //设置一个表达式
        String expression = "50+5*6-10/2";
        //创建两个栈，数栈和符号栈
        ArrayStackPlus numStack = new ArrayStackPlus(10);
        ArrayStackPlus operaStack = new ArrayStackPlus(10);
        //定义需要的变量
        int index = 0; //用于索引 扫描
        int num1 = 0;
        int num2 = 0;
        int opera = 0;
        int result = 0;
        char ch = ' '; //将每次扫描得到的char保存到ch
        String keepNum = ""; //用于拼接多位数的
        //开始while循环扫描expression
        while (true) {
            //依次得到expression中的每一个字符
            ch = expression.charAt(index);
            //如果是运算符
            if (operaStack.isOpera(ch)) {
                //判断当前的符号栈是否为空
                if (!operaStack.isEmpty()) {
                    //如果符号栈不为空，进行比较。如果当前运算符的优先级小于等于栈中的运算符
                    //就需要从数栈中pop出两个数字，再从符号栈中pop出一个符号，进行运算，得到
                    //结果入数栈，然后再将当前的运算符入符号栈
                    if (operaStack.priority(ch) <= operaStack.priority(operaStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opera = operaStack.pop();
                        result = numStack.cal(num1, num2, opera);
                        //将运算结果入数栈
                        numStack.push(result);
                        //将当前运算符入符号栈
                        operaStack.push(ch);
                    } else {
                        //如果当前运算符的优先级大于栈中的运算符
                        operaStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    operaStack.push(ch);
                }
            } else {
                //如果是数字的情况，直接入数栈
                //一定要减去48， 字符1不等于真正的1
                //numStack.push(ch - 48); 单位数的情况

                //1.处理多位数时候，不能发现是一个数，就直接入数栈，可能是多位数
                //2.在处理数时，需要向expression的表达式的index后再看一位
                //3.如果是数，就不能入栈，如果是运算符就直接入栈
                //4.因此需要定义字符串变量用于拼接
                //处理多位数
                keepNum += ch;

                //如果ch已经是expression最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {

                    //判断下一个字符是不是数字
                    if (operaStack.isOpera(expression.charAt(index + 1))) {
                        //如果后一位是运算符，直接入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要重要重要!!!!!!!!! 清空keepNum
                        keepNum = "";
                    }
                }
            }
            //让index + 1，并判断是否扫描到expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            //如果符号栈为空，则计算到最后的结果.数栈中只有一个数字【结果】
            if (operaStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opera = operaStack.pop();
            result = numStack.cal(num1, num2, opera);
            numStack.push(result);
        }
        //最后的结果
        System.out.printf("表达式 %s = %d", expression, numStack.pop());
    }
}
