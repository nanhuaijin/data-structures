package com.breeze.stack.expression;

/**
 * @author breeze
 * @date 2020/2/27
 *
 *  前缀表达式(波兰表达式)
 *      1.前缀表达式的运算符位于操作数之前
 *      2.举例说明：(3+4)*5-6 对应的前缀表达式就是 -*+3456
 *
 *  前缀表达式的计算机求值：
 *      从右到左扫描表达式，遇到数字，将数字压入栈中，遇到运算符，弹出栈顶的两个数，
 *      用运算符对它们做相应的计算(栈顶元素和次顶元素)，并将结果入栈，重复上述过程
 *      知道表达式的最左端，然后运算符得出的值即为表达式的结果
 *
 *      例如：(3+4)*5-6 对应的前缀表达式就是 -*+3456，针对前缀表达式求值步骤如下
 *      1.从右向左扫描，将6,5,4,3压入堆栈
 *      2.遇到 + 运算符，因此弹出3,4，计算 3+4 的值 7，再将7入栈
 *      3.接下来是 * 运算符，弹出7和5，得到 35 入栈
 *      4.最后是 - 运算符， 35 - 6 得到 29，即为最终结果
 */
public class PrefixExpression {
}
