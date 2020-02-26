package com.breeze.linkedlist.joseph;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * Joseph(约瑟夫、约瑟夫环)问题：
 *      设编号1,2...n的n个人围坐一圈，约定编号为k(1<= k <= n)的人从1开始报数，
 *      数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人再出列，依次类推
 *      直到所有的人全部出列，由此产生了一个出队编号的序列
 *
 * 提示：用一个不带头节点的循环链表来处理约瑟夫问题，先构成一个有n节点的单循环链表
 *      然后由k节点起从1开始计数，计到m时，对应节点从链表中删除，然后再从被删除的
 *      节点的下一个节点开始从1计数，知道最后一个节点从链表中删除，算法结束
 */
public class Joseph {
    public static void main(String[] args) {

        //测试  构建单向环形链表
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        //加入5个小孩的节点
        circularSingleLinkedList.addBoy(5);

        //遍历
        circularSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circularSingleLinkedList.countBoy(1, 2, 5);
    }
}
